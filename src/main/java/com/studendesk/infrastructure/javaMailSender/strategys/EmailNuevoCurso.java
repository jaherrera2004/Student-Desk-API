package com.studendesk.infrastructure.javaMailSender.strategys;

import com.studendesk.domain.model.dto.CursoDto;
import com.studendesk.infrastructure.javaMailSender.EnviarEmailStrategy;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailNuevoCurso extends EnviarEmailStrategy {


    public EmailNuevoCurso(JavaMailSender javaMailSender) {
        super(javaMailSender);
    }

    @Override
    public Pair<String,String> construirEmail(Object data) {
        CursoDto cursoDto = (CursoDto) data;

        String contenidoHtml =
                "<html>" +
                        "<body style=\"margin: 0; padding: 0; font-family: Arial, sans-serif; background-color: #f9fafb; color: #333333;\">" +
                        "    <div style=\"max-width: 600px; margin: 20px auto; background-color: #ffffff; border: 1px solid #e5e7eb; border-radius: 8px; overflow: hidden;\">" +
                        "        <div style=\"background-color: #1e3a8a; padding: 20px; text-align: center;\">" +
                        "            <h1 style=\"color: #ffffff; margin: 0; font-size: 24px;\">¡Curso creado exitosamente!</h1>" +
                        "        </div>" +
                        "        <div style=\"padding: 20px;\">" +
                        "            <p style=\"font-size: 16px; line-height: 1.5;\">" +
                        "                Hola <strong>" + cursoDto.getProfesor().getNombre() + "</strong>," +
                        "            </p>" +
                        "            <p style=\"font-size: 16px; line-height: 1.5; color: #4b5563;\">" +
                        "                ¡Felicidades! Has creado un nuevo curso llamado <strong>" + cursoDto.getNombre() + "</strong> en nuestra plataforma." +
                        "            </p>" +
                        "            <p style=\"font-size: 16px; line-height: 1.5; color: #4b5563;\">" +
                        "                Ahora puedes gestionar el contenido de tu curso, interactuar con tus estudiantes y brindarles una experiencia educativa de calidad." +
                        "            </p>" +
                        "            <p style=\"text-align: center; margin: 20px 0;\">" +
                        "                <a href=\"https://tusitio.com\" style=\"background-color: #3b82f6; color: #ffffff; text-decoration: none; padding: 10px 20px; border-radius: 5px; font-size: 16px;\">" +
                        "            </p>" +
                        "            <p style=\"font-size: 14px; line-height: 1.5; color: #6b7280;\">" +
                        "                Si tienes preguntas o necesitas ayuda, no dudes en contactarnos. Estamos aquí para apoyarte." +
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

        return new Pair<>("¡Curso creado exitosamente!", contenidoHtml);
    }
}
