package com.studendesk.domain.model.response;

import com.studendesk.domain.model.dto.config.GeneroDto;
import com.studendesk.domain.model.dto.config.RolDto;
import lombok.AllArgsConstructor;

import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ConfigResponse {

    private List<RolDto> roles;
    private List<GeneroDto> generos;

}
