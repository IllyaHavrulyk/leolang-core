package com.leolang.core.api.controller;

import com.leolang.core.api.dto.TranslationRequestDto;
import com.leolang.core.api.dto.systran.translate.text.TargetDto;
import com.leolang.core.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translations")
@RequiredArgsConstructor
public class TranslationController {

    private final TranslationService translationService;

    @RequestMapping(method = {RequestMethod.GET}, path = {"/translate"})
    public ResponseEntity<TargetDto> translate(@RequestBody TranslationRequestDto translateDto) {
        TargetDto translatedText = translationService.translate(translateDto);
        return new ResponseEntity<>(translatedText, HttpStatus.OK);
    }
}
