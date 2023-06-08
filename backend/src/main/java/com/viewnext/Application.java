package com.viewnext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase principal de la aplicación Spring Boot.
 * Esta clase contiene en parte la configuración de la aplicación.
 * La anotación @SpringBootApplication indica que esta clase es la clase principal de la aplicación.
 * La anotación @EnableWebMvc habilita la configuración web.
 * La anotación @Bean indica que el método que la contiene devuelve un objeto que debe ser registrado como un bean en el contenedor de Spring.
 */
@SpringBootApplication
@EnableWebMvc // Habilita la configuración web
public class Application {
    /**
     * Método principal de la aplicación.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    /**
     * Configuración CORS para permitir peticiones desde el cliente Angular.
     * En este caso, se permite que el cliente Angular realice peticiones GET y POST desde localhost:4200.
     * Sirve principalmente si estas ejecutando el cliente y servidor en el mismo equipo.
     * @return Configuración CORS.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/send")
                        .allowedOrigins("http://localhost:4200") // Permitir solicitudes desde localhost:4200
                        .allowedMethods("GET", "POST"); // Permitir solicitudes GET y POST
            }
        };
    }

}
