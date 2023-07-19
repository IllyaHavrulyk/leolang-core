package com.leolang.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // lesson 9 // focus on CORS
        http.authorizeRequests()
                .anyRequest().permitAll();

        http.cors(c -> {
            CorsConfigurationSource cs = r -> {
                CorsConfiguration cc = new CorsConfiguration();
                cc.setAllowedOrigins(List.of("*"));
                cc.setAllowedMethods(List.of("GET", "POST"));
                cc.setAllowedHeaders(List.of("*"));
                return cc;
            };

            c.configurationSource(cs);
        });
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(64000);
        return loggingFilter;
    }
}
