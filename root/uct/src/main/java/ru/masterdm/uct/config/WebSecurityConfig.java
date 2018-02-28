package ru.masterdm.uct.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.cors.CorsConfiguration;

/**
 * Spring configuration for security.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger("application");

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOG.info("----   Configuring security...");
        http.csrf().disable().authorizeRequests().anyRequest().authenticated()
                .and().x509().subjectPrincipalRegex("(.*)")
                .userDetailsService(userDetailsService());

        //TODO must be removed from production code
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }

    /**
     * Extracts user's details.
     * @return UserDetailsService
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                LOG.info("----   loadUserByUsername " + username);
                if (username.startsWith("user")) {
                    return new User(username, "",
                            AuthorityUtils
                                    .commaSeparatedStringToAuthorityList("ROLE_USER"));
                }
                return new User(username, "",
                        AuthorityUtils
                                .commaSeparatedStringToAuthorityList("ROLE_ANONYMOUS"));
            };
        };
    }
}
