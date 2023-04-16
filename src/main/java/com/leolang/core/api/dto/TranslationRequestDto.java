package com.leolang.core.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TranslationRequestDto {
    private List<String> input;
    private String target;
    private String source;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private UUID profile;
    private boolean withInfo;
    private boolean withSource;
    private boolean withAnnotations;
    private List<Object> options;
    private String format;
}
