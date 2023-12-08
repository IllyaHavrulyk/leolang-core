package com.leolang.core.api.dto.systran.translate.text;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Output {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Info info;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String output;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String backTranslation;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String source;
}
