package com.studendesk.infrastructure.javaMailSender;

import com.studendesk.domain.emailSenderPort.TIPOS_CORREOS;
import com.studendesk.infrastructure.javaMailSender.strategys.EmailNuevoCurso;
import com.studendesk.infrastructure.javaMailSender.strategys.EmailRegistro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class EmailStrategyConfig {

    @Bean
    public Map<TIPOS_CORREOS, EnviarEmailStrategy> emailStrategies(
            EmailRegistro emailRegistro,
            EmailNuevoCurso emailNuevoCurso
    ) {
        return Map.of(
                TIPOS_CORREOS.REGISTRO, emailRegistro,
                TIPOS_CORREOS.NUEVO_CURSO, emailNuevoCurso

        );
    }
}
