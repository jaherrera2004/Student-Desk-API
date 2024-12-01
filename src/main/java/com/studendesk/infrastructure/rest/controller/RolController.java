package com.studendesk.infrastructure.rest.controller;

import com.studendesk.application.service.interfaces.RolIService;
import com.studendesk.domain.consts.DatosGenerales;
import com.studendesk.domain.model.dto.config.RolDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(DatosGenerales.BASE_PATH+"/roles")
public class RolController {

    private final RolIService rolService;

    @GetMapping
    public List<RolDto> obtenerRoles(){
        return rolService.obtenerRoles();
    }
}
