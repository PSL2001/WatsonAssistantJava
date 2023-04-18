package com.viewnext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/*  
 * Representa una respuesta genérica devuelta por el servicio de Watson Assistant.
 * Una respuesta genérica es un objeto que contiene el tipo de respuesta y el texto de la respuesta.
 * Por ejemplo, en la oración "Quiero reservar una habitación para dos personas",
 * la respuesta genérica puede ser "text" con el texto "¿Cuándo quieres reservar la habitación?".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatsonAssistantGeneric {
    private String responseType;
    private String text;

    public String getResponseType() {
        return responseType;
    }

    @JsonProperty("response_type")
    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}


