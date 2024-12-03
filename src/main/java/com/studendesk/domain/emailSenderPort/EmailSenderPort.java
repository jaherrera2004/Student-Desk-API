package com.studendesk.domain.emailSenderPort;

public interface EmailSenderPort {
    void enviarCorreo(String destinatario, Object data, TIPOS_CORREOS tipoCorreo);
}
