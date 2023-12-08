package com.leolang.core.api.dto.systran.translate.text;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    private String profileId;
    private String queue;
    private String service;
    private BigDecimal version;
    private Selector selectors;
    private int priority;
}
