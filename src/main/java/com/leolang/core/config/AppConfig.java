package com.leolang.core.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
@EnableConfigurationProperties({TranslationApiProperties.class})
public class AppConfig {

    private static final int NUMBER_OF_SECONDS = 90;
    private static final int NUMBER_TO_CONVERT_SECONDS_TO_MILLISECONDS = 1000;

    @Bean
    public RestTemplate jsonRestTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        int timeout = NUMBER_TO_CONVERT_SECONDS_TO_MILLISECONDS * NUMBER_OF_SECONDS;
        httpRequestFactory.setConnectionRequestTimeout(timeout);
        httpRequestFactory.setConnectTimeout(timeout);
        httpRequestFactory.setReadTimeout(timeout);
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
        return restTemplate;
    }

}
