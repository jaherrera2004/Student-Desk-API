package com.studendesk.infrastructure.rest.controller;

import com.studendesk.application.service.interfaces.ConfigIService;
import com.studendesk.domain.consts.DatosGenerales;
import com.studendesk.domain.model.response.ConfigResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(DatosGenerales.BASE_PATH + "/config")
public class ConfigController {

    private final ConfigIService configIService;

    @GetMapping
    public ConfigResponse getConfigData() {
        return configIService.obtenerConfigData();
    }
}
