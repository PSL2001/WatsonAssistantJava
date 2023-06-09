package com.viewnext;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
/**
 * Clase de configuración de la aplicación.
 * Esta clase contiene las propiedades de configuración de la aplicación.
 * La anotación @Configuration indica que esta clase es una clase de configuración.
 * La anotación @ConfigurationProperties indica que esta clase contiene propiedades de configuración.
 * La anotación @Data es una anotación de Lombok que genera automáticamente getters y setters.
 * Las anotaciones @NotNull, @NotBlank y @Pattern son anotaciones de validación de Bean Validation.
 * Estas anotaciones se utilizan para validar las propiedades de configuración.
 * En caso de que alguna propiedad no cumpla con las validaciones, se lanzará una excepción, y la aplicación no se iniciará.
 * Tambien mostrará un mensaje de error indicando el problema.
 */
@Configuration
@ConfigurationProperties(prefix = "ibm.watson.assistant")
@Data // Anotación de Lombok para generar automáticamente getters y setters
public class WatsonAssistantConfig {

    /**
     * Clave de la api de Watson Assistant.
     * Esta propiedad se obtiene del fichero application.properties.
     * La anotación @NotNull indica que esta propiedad no puede ser nula.
     * La anotación @NotBlank indica que esta propiedad no puede estar en blanco.
     * La anotación @Pattern indica que esta propiedad debe cumplir con la expresión regular indicada.
     */
    @NotNull(message = "La clave del asistente es obligatorio")
    @NotBlank(message = "La clave del asistente no puede estar en blanco")
    @Pattern(regexp = "[a-zA-Z0-9_]*", message = "La clave de la api tiene caracteres no validos")
    private String apikey;
    /**
     * Id del asistente de Watson Assistant.
     * Esta propiedad se obtiene del fichero application.properties.
     * La anotación @NotNull indica que esta propiedad no puede ser nula.
     * La anotación @NotBlank indica que esta propiedad no puede estar en blanco.
     * La anotación @Pattern indica que esta propiedad debe cumplir con la expresión regular indicada.
     */
    @NotNull(message = "El id de asistente es obligatorio")
    @NotBlank(message = "El id de asistente es obligatorio")
    @Pattern(regexp = "[a-z-A-Z0-9-]*", message = "El id de asistente tiene caracteres no válidos")
    private String id;
    /**
     * Url del servicio de Watson Assistant.
     * Esta propiedad se obtiene del fichero application.properties.
     * La anotación @NotNull indica que esta propiedad no puede ser nula.
     * La anotación @NotBlank indica que esta propiedad no puede estar en blanco.
     * La anotación @Pattern indica que esta propiedad debe cumplir con la expresión regular indicada.
     * La expresión regular utilizada es una expresión regular para validar urls.
     * 
     */
    @NotNull(message = "La url del servicio es obligatoria")
    @NotBlank(message = "La url del servicio es obligatoria")
    @Pattern(
            regexp = "https:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\/\\/=]*)",
            message = "La url del servicio contiene errores"
    )
    private String url;
    /**
     * Versión del servicio de Watson Assistant.
     * Esta propiedad se obtiene del fichero application.properties.
     * La anotación @NotNull indica que esta propiedad no puede ser nula.
     * La anotación @NotBlank indica que esta propiedad no puede estar en blanco.
     * La anotación @Pattern indica que esta propiedad debe cumplir con la expresión regular indicada.
     * La expresión regular utilizada es una expresión regular para validar fechas.
     */
    @NotNull(message = "La fecha de versión es obligatoria")
    @NotBlank(message = "La fecha de versión es obligatoria")
    @Pattern(
            regexp = "^\\d{4}(-)(((0)[0-9])|((1)[0-2]))(-)([0-2][0-9]|(3)[0-1])$",
            message = "La fecha de versión contiene errores, debe tener el formato DD-MM-AAAA"
    )
    private String version;

}
