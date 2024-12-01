package com.studendesk.application.service.interfaces;

import com.studendesk.domain.model.request.AuthRequest;
import com.studendesk.domain.model.response.AuthResponse;

public interface AuthIService {
    AuthResponse iniciarSesion(AuthRequest request);
}
