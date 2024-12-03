package com.studendesk.domain.model.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GenericResponse {

    private boolean status;
    private String mensaje;

    public static GenericResponse ok(boolean status, String mensaje) {
        return new GenericResponse(status, mensaje);
    }
}