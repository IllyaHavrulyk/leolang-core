package com.leolang.core.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leolang.core.api.dto.systran.profiles.Profile;
import com.leolang.core.api.dto.systran.profiles.dto.ListProfilesRequestDto;
import com.leolang.core.api.dto.systran.profiles.dto.ListProfilesResponseDto;
import com.leolang.core.service.ProfilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfilesServiceImpl implements ProfilesService {
    private final RestService restService;
    private final ObjectMapper objectMapper;

    @Override
    public ListProfilesResponseDto listProfiles(ListProfilesRequestDto listProfilesRequestDto) {
        return restService.listProfiles(listProfilesRequestDto);
    }

    @Override
    public List<Profile> listProfilesFromJson(ListProfilesRequestDto dto) throws IOException {
        File file = ResourceUtils.getFile("classpath:systran_profiles.json");
        ListProfilesResponseDto listProfilesResponseDto = objectMapper.readValue(file, ListProfilesResponseDto.class);
        return listProfilesResponseDto.getProfiles().stream()
                .filter(Profile::isActivated)
                .filter(profile ->  profile.getTarget().equals(dto.getTarget()) && profile.getSource().equals(dto.getSource()))
                .collect(Collectors.toList());
    }


}
