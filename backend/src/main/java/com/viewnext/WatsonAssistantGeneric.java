package com.viewnext;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/*  
 * Representa una respuesta genérica devuelta por el servicio de Watson Assistant.
 * Una respuesta genérica es un objeto que contiene el tipo de respuesta y el texto de la respuesta.
 * Por ejemplo, en la oración "Quiero reservar una habitación para dos personas",
 * la respuesta genérica puede ser "text" con el texto "¿Cuándo quieres reservar la habitación?".
 * La anotación @JsonIgnoreProperties indica que las propiedades desconocidas deben ser ignoradas.
 * Esto es útil cuando se reciben respuestas de Watson Assistant que contienen propiedades desconocidas.
 * En este caso, las propiedades desconocidas se ignoran y no se produce una excepción.
 * La anotación @JsonProperty indica que el campo que la contiene es una propiedad JSON.
 * Esto es útil cuando se reciben respuestas de Watson Assistant que contienen propiedades con nombres que no siguen las convenciones de Java.
 * En este caso, la propiedad "response_type" se asigna al campo "responseType".
 * La anotación @JsonProperty también se utiliza para asignar un campo a una propiedad JSON con un nombre diferente.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatsonAssistantGeneric {
    /**
     * Tipo de respuesta.
     * Puede ser "text" o "option" o "image".
     * Si es "text", el campo "text" contiene el texto de la respuesta.
     * Si es "option", el campo "options" contiene una lista de opciones.
     * Si es "image", el campo "source" contiene la URL de la imagen.
     * Si es "option", el campo "title" contiene el título de la respuesta.
     * Si es "option", el campo "options" contiene una lista de opciones.
     */
    private String responseType;
    private String text;
    private String source;
    private String title;
    private List<WatsonAssistantOption> options;
    /**
     * Getter de responseType.
     * @return Tipo de respuesta.
     */
    public String getResponseType() {
        return responseType;
    }
    /**
     * Setter de responseType.
     * Viene de la propiedad "response_type" de la respuesta JSON de Watson Assistant.
     * @param responseType Tipo de respuesta.
     */
    @JsonProperty("response_type")
    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
    /**
     * Getter de text.
     * @return Texto de la respuesta.
     */
    public String getText() {
        return text;
    }
    /**
     * Setter de text.
     * Viene de la propiedad "text" de la respuesta JSON de Watson Assistant.
     * @param text Texto de la respuesta.
     */
    public void setText(String text) {
        this.text = text;
    }
    /**
     * Getter de source.
     * @return URL de la imagen.
     */
    public String getSource() {
        return source;
    }
    /**
     * Setter de source.
     * Viene de la propiedad "source" de la respuesta JSON de Watson Assistant.
     * @param source URL de la imagen.
     */
    public void setSource(String source) {
        this.source = source;
    }
    /**
     * Getter de title.
     * @return Título de la respuesta.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Setter de title.
     * Viene de la propiedad "title" de la respuesta JSON de Watson Assistant.
     * @param title Título de la respuesta.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Getter de options.
     * @return Lista de opciones.
     */
    public List<WatsonAssistantOption> getOptions() {
        return options;
    }
    /**
     * Setter de options.
     * Viene de la propiedad "options" de la respuesta JSON de Watson Assistant.
     * @param options Lista de opciones.
     */
    public void setOptions(List<WatsonAssistantOption> options) {
        this.options = options;
    }
    /**
     * Método toString.
     * @return String
     */
    @Override
    public String toString() {
        return "WatsonAssistantGeneric [responseType=" + responseType + ", text=" + text + ", source=" + source + ", title=" + title + ", options=" + options + "]";
    }
}
