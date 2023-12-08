package com.leolang.core.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leolang.core.api.dto.TranslationRequestDto;
import com.leolang.core.api.dto.systran.profiles.Profile;
import com.leolang.core.api.dto.systran.profiles.dto.ListProfilesRequestDto;
import com.leolang.core.api.dto.systran.translate.text.Output;
import com.leolang.core.api.dto.systran.translate.text.dto.TargetDto;
import com.leolang.core.service.ProfilesService;
import com.leolang.core.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static java.util.concurrent.CompletableFuture.completedFuture;

@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {

    private final RestService restService;
    private final ProfilesService profilesService;
    private final ObjectMapper objectMapper;

    @Override
    public TargetDto translate(TranslationRequestDto translateDto) throws IOException {
        List<Profile> profiles = profilesService.listProfilesFromJson(prepareListProfilesDto(translateDto));
        Set<String> translations = profiles.stream()
                .map(profile -> translateAsync(prepareDtoWithProfile(translateDto, profile)))
                .map(futureTranslation -> {
                    try {
                        return futureTranslation.get().getOutputs().get(0).getOutput();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toSet());
        return prepareTargetDto(prepareOutputs(translations));
    }

    private Set<Output> prepareOutputs(Set<String> translations) {
        return translations.stream()
                .map(translation -> Output.builder().output(translation).build())
                .collect(Collectors.toSet());
    }

    @Async
    @Override
    public CompletableFuture<TargetDto> translateAsync(TranslationRequestDto translateDto) {
        return completedFuture(restService.translateText(translateDto));
    }

    private TargetDto prepareTargetDto(Set<Output> outputs){
        return TargetDto.builder()
                .outputs(new ArrayList<>(outputs))
                .build();
    }

    private ListProfilesRequestDto prepareListProfilesDto(TranslationRequestDto translateDto) {
        return ListProfilesRequestDto.builder()
                .target(translateDto.getTarget())
                .source(translateDto.getSource())
                .build();
    }

    private TranslationRequestDto prepareDtoWithProfile(TranslationRequestDto dtoWithoutProfile, Profile profile) {
        TranslationRequestDto dtoWithProfile = objectMapper.convertValue(dtoWithoutProfile, TranslationRequestDto.class);
        dtoWithProfile.setProfile(UUID.fromString(profile.getId()));
        return dtoWithProfile;
    }
}
