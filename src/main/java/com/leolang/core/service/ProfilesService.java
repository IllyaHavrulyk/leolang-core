package com.leolang.core.service;

import com.leolang.core.api.dto.systran.profiles.Profile;
import com.leolang.core.api.dto.systran.profiles.dto.ListProfilesRequestDto;
import com.leolang.core.api.dto.systran.profiles.dto.ListProfilesResponseDto;

import java.io.IOException;
import java.util.List;

public interface ProfilesService {
    ListProfilesResponseDto listProfiles(ListProfilesRequestDto listProfilesRequestDto);
    List<Profile> listProfilesFromJson(ListProfilesRequestDto listProfilesRequestDto) throws IOException;
    
}
