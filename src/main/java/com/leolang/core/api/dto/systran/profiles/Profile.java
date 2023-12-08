package com.leolang.core.api.dto.systran.profiles;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private String id;
    private String name;
    private boolean activated;
    private boolean running;
    private String source;
    private String target;
    private String sharingStatus;
    private String owner;
    private String domain;
    private String size;
    private String techno;
    private String accountId;
    private String insertionTime;
    private List<Dictionary> dictionaries;
    private List<Normalization> normalizations;
    private List<TranslationMemory> translationMemories;
    private String translationResourceId;
    private String creatorName;
    private String pivot;
    @JsonProperty(value = "supported_features")
    private Map<String, Boolean> supportedFeatures;
}
