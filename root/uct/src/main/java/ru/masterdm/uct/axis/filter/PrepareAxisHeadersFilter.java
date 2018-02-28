package ru.masterdm.uct.axis.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.axis.transport.http.HTTPConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

/**
 * Checks and fixes HTTP-headers for Axis.
 * @author Sergey Valiev
 */
public class PrepareAxisHeadersFilter implements Filter {

    public static final String INVALID_ENCODING = "cl8mswin1251";
    public static final String VALID_ENCODING = "windows-1251";
    public static final Pattern pattern = Pattern.compile(INVALID_ENCODING, Pattern.CASE_INSENSITIVE);

    private static final Logger LOGGER = LoggerFactory.getLogger(PrepareAxisHeadersFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpRequest) {
            @Override
            public String getHeader(String name) {
                String headerValue = super.getHeader(name);
                if (name.equalsIgnoreCase(HttpHeaders.CONTENT_TYPE)) {
                    headerValue = pattern.matcher(headerValue).replaceAll(VALID_ENCODING);
                    LOGGER.debug(String.format("Overriden header $s: $s", HttpHeaders.CONTENT_TYPE, headerValue));
                }
                if (name.equalsIgnoreCase(HTTPConstants.HEADER_SOAP_ACTION)) {
                    headerValue = "";
                }

                return headerValue;
            }
        };
        chain.doFilter(wrapper, response);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
