package com.studendesk.infrastructure.javaMailSender.strategys;

import com.studendesk.domain.model.dto.UsuarioDto;
import com.studendesk.infrastructure.javaMailSender.EnviarEmailStrategy;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailRegistro extends EnviarEmailStrategy {


    public EmailRegistro(JavaMailSender javaMailSender) {
        super(javaMailSender);
    }

    @Override
    public Pair<String,String> construirEmail(Object data) {
        UsuarioDto usuarioDto = (UsuarioDto) data;

        String contenidoHtml =
                "<html>" +
                        "<body style=\"margin: 0; padding: 0; font-family: Arial, sans-serif; background-color: #f9fafb; color: #333333;\">" +
                        "    <div style=\"max-width: 600px; margin: 20px auto; background-color: #ffffff; border: 1px solid #e5e7eb; border-radius: 8px; overflow: hidden;\">" +
                        "        <div style=\"background-color: #1e3a8a; padding: 20px; text-align: center;\">" +
                        "            <h1 style=\"color: #ffffff; margin: 0; font-size: 24px;\">¡Bienvenido a nuestra comunidad!</h1>" +
                        "        </div>" +
                        "        <div style=\"padding: 20px;\">" +
                        "            <p style=\"font-size: 16px; line-height: 1.5;\">" +
                        "                Hola <strong>" + usuarioDto.getNombre()+ "</strong>," +
                        "            </p>" +
                        "            <p style=\"font-size: 16px; line-height: 1.5; color: #4b5563;\">" +
                        "                Nos emociona tenerte aquí. Estamos comprometidos a ofrecerte la mejor experiencia posible." +
                        "                Si tienes alguna pregunta o necesitas ayuda, no dudes en contactarnos." +
                        "            </p>" +
                        "            <p style=\"text-align: center; margin: 20px 0;\">" +
                        "                <a href=\"https://tusitio.com\" style=\"background-color: #3b82f6; color: #ffffff; text-decoration: none; padding: 10px 20px; border-radius: 5px; font-size: 16px;\">" +
                        "                    Visita nuestro sitio" +
                        "                </a>" +
                        "            </p>" +
                        "            <p style=\"font-size: 14px; line-height: 1.5; color: #6b7280;\">" +
                        "                Gracias por unirte a nosotros. Estamos aquí para ayudarte en cada paso del camino." +
                        "            </p>" +
                        "        </div>" +
                        "        <div style=\"background-color: #f3f4f6; padding: 10px; text-align: center;\">" +
                        "            <p style=\"font-size: 12px; color: #9ca3af; margin: 0;\">" +
                        "                &copy; 2024 StudentDesk. Todos los derechos reservados." +
                        "            </p>" +
                        "        </div>" +
                        "    </div>" +
                        "</body>" +
                        "</html>";


        return new Pair<>("¡Bienvenido a nuestra comunidad!", contenidoHtml);
    }


}
