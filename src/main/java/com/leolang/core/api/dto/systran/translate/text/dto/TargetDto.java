package com.leolang.core.api.dto.systran.translate.text.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leolang.core.api.dto.systran.translate.text.Error;
import com.leolang.core.api.dto.systran.translate.text.Output;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TargetDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Error error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String requestId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Output> outputs;
}
