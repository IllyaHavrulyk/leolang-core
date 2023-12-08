package com.leolang.core.service;

import com.leolang.core.api.dto.TranslationRequestDto;
import com.leolang.core.api.dto.systran.translate.text.dto.TargetDto;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface TranslationService {
    TargetDto translate(TranslationRequestDto translateDto) throws IOException;
    CompletableFuture<TargetDto> translateAsync(TranslationRequestDto translateDto);
}
