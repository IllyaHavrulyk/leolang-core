package com.leolang.core.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leolang.core.api.dto.TranslationRequestDto;
import com.leolang.core.api.dto.systran.profiles.dto.ListProfilesRequestDto;
import com.leolang.core.api.dto.systran.profiles.dto.ListProfilesResponseDto;
import com.leolang.core.api.dto.systran.translate.text.dto.SourceDto;
import com.leolang.core.api.dto.systran.translate.text.dto.TargetDto;
import com.leolang.core.config.SystranApiProperties;
import lombok.RequiredArgsConstructor;
import org.apache.http.entity.ContentType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class RestService {
    private final RestTemplate jsonRestTemplate;
    private final SystranApiProperties systranApiProperties;
    private final ObjectMapper objectMapper;

    private static final String AUTHORIZATION_TEMPLATE = "Key %s";

    public TargetDto translateText(TranslationRequestDto translationRequestDto) {
        URI uri = UriComponentsBuilder
                .fromUriString(systranApiProperties.getTextUrl())
                .build()
                .toUri();

        SourceDto sourceDto = objectMapper.convertValue(translationRequestDto, SourceDto.class);
        return jsonRestTemplate.exchange(uri.toString(), HttpMethod.POST,
                new HttpEntity<>(sourceDto, prepareHeaders()), TargetDto.class).getBody();
    }

    public ListProfilesResponseDto listProfiles(ListProfilesRequestDto listProfilesRequestDto){
        URI uri = UriComponentsBuilder
                .fromUriString(systranApiProperties.getProfilesUrl())
                .build()
                .toUri();
        return jsonRestTemplate.exchange(uri.toString(), HttpMethod.GET, new HttpEntity<>(listProfilesRequestDto, prepareHeaders()), ListProfilesResponseDto.class).getBody();
    }

    private HttpHeaders prepareHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.put(HttpHeaders.AUTHORIZATION, List.of(format(AUTHORIZATION_TEMPLATE,
                systranApiProperties.getKey())));
        headers.put(HttpHeaders.CONTENT_TYPE, Collections.singletonList(ContentType.APPLICATION_JSON.toString()));
        return headers;
    }
}