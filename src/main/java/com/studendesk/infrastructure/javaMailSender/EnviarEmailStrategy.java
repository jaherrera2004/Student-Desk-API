package com.studendesk.infrastructure.javaMailSender;

import com.studendesk.domain.consts.DatosGenerales;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@RequiredArgsConstructor
public abstract class EnviarEmailStrategy {

    private final JavaMailSender javaMailSender;

    void enviarCorreo(String destinatario, Object data){
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

            helper.setFrom(DatosGenerales.EMAIL);
            helper.setTo(destinatario);
            helper.setSubject(construirEmail(data).a);
            helper.setText(construirEmail(data).b, true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar correo electrónico", e);
        }
    }

    protected abstract Pair<String,String> construirEmail(Object data);
    //a -> subject, b -> content
}
