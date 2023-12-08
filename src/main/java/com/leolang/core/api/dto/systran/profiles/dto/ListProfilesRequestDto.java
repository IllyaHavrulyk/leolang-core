package com.leolang.core.api.dto.systran.profiles.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListProfilesRequestDto {
    private String source;
    private String target;
}
