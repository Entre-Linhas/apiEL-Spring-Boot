package com.entrelinhas.apiel.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Defina o padrão de URL para o qual deseja aplicar as configurações do CORS
                        .allowedOrigins("*") // Defina os domínios permitidos para acessar o servidor
                        .allowedMethods("*") // Defina os métodos HTTP permitidos
                        .allowedHeaders("*"); // Defina os cabeçalhos permitidos
            }
        };
    }
}