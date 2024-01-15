package com.leolang.core.api.dto.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateHistoryItemDto {
    private String sourceText;
    private String sourceLanguage;
    private String targetText;
    private String targetLanguage;
}
