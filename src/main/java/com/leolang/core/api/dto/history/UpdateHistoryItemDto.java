package com.leolang.core.api.dto.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHistoryItemDto {
    @JsonInclude(NON_NULL)
    private Long id;
    private String sourceText;
    private String sourceLanguage;
    private String targetText;
    private String targetLanguage;
}
