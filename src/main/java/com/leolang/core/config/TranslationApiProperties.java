package com.leolang.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Validated
@ConfigurationProperties("translation-api")
public class TranslationApiProperties {
    @NotBlank
    private String baseUrl;

    @NotBlank
    private String textUrl;

    @NotBlank
    private String profilesUrl;

    @NotBlank
    private String key;
}
