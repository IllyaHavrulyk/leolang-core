package com.leolang.core.service;

import com.leolang.core.api.dto.TranslationRequestDto;
import com.leolang.core.api.dto.systran.translate.text.TargetDto;

public interface TranslationService {
    TargetDto translate(TranslationRequestDto translateDto);
}
