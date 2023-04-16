package com.leolang.core.service.impl;

import com.leolang.core.api.dto.TranslationRequestDto;
import com.leolang.core.api.dto.systran.translate.text.TargetDto;
import com.leolang.core.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {

    private final RestService restService;

    @Override
    public TargetDto translate(TranslationRequestDto translateDto) {
        return restService.translateText(translateDto);
    }
}
