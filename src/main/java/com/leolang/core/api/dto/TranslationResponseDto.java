package com.leolang.core.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TranslationResponseDto {
    private String sourceLanguage;
    private String sourceText;
    private String targetLanguage;
    private String targetText;
}
