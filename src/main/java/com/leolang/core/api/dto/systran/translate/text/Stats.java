package com.leolang.core.api.dto.systran.translate.text;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stats {
    @JsonProperty("elapsed_time")
    private Long elapsedTime;
    @JsonProperty("nb_cache_hits")
    private Long cacheHits;
    @JsonProperty("nb_char_in_cache_hits")
    private Long charInCacheHits;
    @JsonProperty("nb_characters")
    private Long characters;
    @JsonProperty("nb_total_segments")
    private Long totalSegments;
    @JsonProperty("nb_trivial_characters")
    private Long trivialCharacters;
    @JsonProperty("nb_trivial_tus")
    private Long trivialTus;
    @JsonProperty("nb_tus")
    private Long tus;
    @JsonProperty("nb_tus_failed")
    private Long tusFailed;
}
