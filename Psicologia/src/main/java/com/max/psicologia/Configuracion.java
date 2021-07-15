package com.max.psicologia;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@Configuration
public class Configuracion {
    @Bean
    LocaleResolver localeResolver() {
        // Force english for Spring Security error messages
        return new FixedLocaleResolver(new Locale("es"));
    }
}
