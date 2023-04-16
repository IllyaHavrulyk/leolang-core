package com.leolang.core.api.dto.systran.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    @JsonProperty(value = "lid")
    private LanguageId languageId;
    @JsonProperty(value = "selected_routes")
    private List<SelectedRoute> selectedRoutes;
    private Stats stats;
}
