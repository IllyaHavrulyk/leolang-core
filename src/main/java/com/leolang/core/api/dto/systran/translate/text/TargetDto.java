package com.leolang.core.api.dto.systran.translate.text;

import com.leolang.core.api.dto.systran.domain.Error;
import com.leolang.core.api.dto.systran.domain.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TargetDto {
    private Error error;
    private String requestId;
    private List<Output> outputs;
}
