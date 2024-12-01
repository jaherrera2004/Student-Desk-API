package com.studendesk.domain.model.response;


import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class AuthResponse {

    private String message;
    private String token;

}
