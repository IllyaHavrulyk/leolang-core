package com.leolang.core.service.impl;

import com.leolang.core.api.dto.TranslationRequestDto;
import com.leolang.core.api.dto.systran.translate.text.SourceDto;
import com.leolang.core.api.dto.systran.translate.text.TargetDto;
import com.leolang.core.config.TranslationApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class RestService {
    private final RestTemplate jsonRestTemplate;
    private final TranslationApiProperties translationApiProperties;

    private static final String AUTHORIZATION_TEMPLATE = "Key %s";

    public TargetDto translateText(TranslationRequestDto sourceDto) {
        URI uri = UriComponentsBuilder
                .fromUriString(translationApiProperties.getTextUrl())
                .build()
                .toUri();

        return jsonRestTemplate.exchange(uri.toString(), HttpMethod.POST,
                new HttpEntity<>(sourceDto, prepareHeaders()), TargetDto.class).getBody();
    }

    private HttpHeaders prepareHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.put(HttpHeaders.AUTHORIZATION, List.of(format(AUTHORIZATION_TEMPLATE,
                translationApiProperties.getKey())));
        return headers;
    }
}