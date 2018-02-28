package ru.masterdm.uct.config;

import org.apache.axis.EngineConfigurationFactory;
import org.apache.axis.transport.http.AxisServlet;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import ru.masterdm.uct.axis.filter.PrepareAxisHeadersFilter;

/**
 * Spring configuration for Axis.
 */
@Configuration
public class AxisConfig {

    /**
     * Returns Axis bean.
     * @return ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean axisServletRegistrationBean() {
        System.setProperty(EngineConfigurationFactory.SYSTEM_PROPERTY_NAME, ru.masterdm.uct.axis.EngineConfigurationFactory.class.getName());
        AxisServlet servlet = new AxisServlet();
        ServletRegistrationBean servletBean = new ServletRegistrationBean(servlet, "/soap/*");
        return servletBean;
    }

    /**
     * HTTP-request logging filter.
     * @return HTTP-request logging filter
     */
    @Bean
    public CommonsRequestLoggingFilter commonsRequestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setBeforeMessagePrefix("----   Before request:\n[");
        loggingFilter.setAfterMessagePrefix("----   After request:\n[");
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setIncludeHeaders(true);
        loggingFilter.setMaxPayloadLength(Long.valueOf(FileUtils.ONE_MB).intValue());
        return loggingFilter;
    }

    /**
     * Set valid AXIS header filter.
     * @return valid AXIS header filter
     */
    @Bean
    public FilterRegistrationBean prepareAxisHeadersFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new PrepareAxisHeadersFilter());
        registration.addUrlPatterns("/soap/*");
        registration.setName("prepareAxisHeadersFilter");
        registration.setOrder(2);
        return registration;
    }
}