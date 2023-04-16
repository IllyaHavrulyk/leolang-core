package com.leolang.core.api.dto.systran.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Output {
    private String error;
    private Info info;
    private String output;
    private String backTranslation;
    private String source;
}
