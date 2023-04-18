package com.viewnext;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "ibm.watson.assistant")
@Data // Anotación de Lombok para generar automáticamente getters y setters
public class WatsonAssistantConfig {

    // Validación de las propiedades de configuración
    @NotNull(message = "La clave del asistente es obligatorio")
    @NotBlank(message = "La clave del asistente no puede estar en blanco")
    @Pattern(regexp = "[a-zA-Z0-9_]*", message = "La clave de la api tiene caracteres no validos")
    private String apikey;
    
    @NotNull(message = "El id de asistente es obligatorio")
    @NotBlank(message = "El id de asistente es obligatorio")
    @Pattern(regexp = "[a-z-A-Z0-9-]*", message = "El id de asistente tiene caracteres no válidos")
    private String id;

    @NotNull(message = "La url del servicio es obligatoria")
    @NotBlank(message = "La url del servicio es obligatoria")
    @Pattern(
            regexp = "https:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\/\\/=]*)",
            message = "La url del servicio contiene errores"
    )
    private String url;

    @NotNull(message = "La fecha de versión es obligatoria")
    @NotBlank(message = "La fecha de versión es obligatoria")
    @Pattern(
            regexp = "^\\d{4}(-)(((0)[0-9])|((1)[0-2]))(-)([0-2][0-9]|(3)[0-1])$",
            message = "La fecha de versión contiene errores, debe tener el formato DD-MM-AAAA"
    )
    private String version;

}
