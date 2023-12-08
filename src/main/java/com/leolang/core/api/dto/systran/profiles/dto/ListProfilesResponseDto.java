package com.leolang.core.api.dto.systran.profiles.dto;

import com.leolang.core.api.dto.systran.profiles.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListProfilesResponseDto {
    private int total;
    private int offset;
    private List<Profile> profiles;
}
