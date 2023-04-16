package com.leolang.core.api.dto.systran.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Selector {
    private String domain;
    private String owner;
    private String size;
    private Tech tech;
}
