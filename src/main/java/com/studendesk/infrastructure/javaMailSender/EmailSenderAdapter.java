package com.studendesk.infrastructure.javaMailSender;

import com.studendesk.domain.emailSenderPort.EmailSenderPort;
import com.studendesk.domain.emailSenderPort.TIPOS_CORREOS;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class EmailSenderAdapter implements EmailSenderPort {

    private final Map<TIPOS_CORREOS, EnviarEmailStrategy> emailStrategies;

    @Override
    public void enviarCorreo(String destinatario, Object data, TIPOS_CORREOS tipoCorreo) {
        EnviarEmailStrategy enviarEmail = emailStrategies.get(tipoCorreo);
        if (enviarEmail == null) {
            throw new IllegalStateException("Tipo de correo no soportado: " + tipoCorreo);
        }
        enviarEmail.enviarCorreo(destinatario, data);
    }
}
