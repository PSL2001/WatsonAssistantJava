package com.viewnext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * WatsonAssistantOptionValue
 * Esta clase representa el valor de una opción de respuesta de Watson Assistant.
 * El valor de una opción es el texto que se envía al servidor cuando el usuario
 * selecciona una opción.
 * Esta clase se utiliza en la clase WatsonAssistantOptionValue cuando se recibe una
 * respuesta de Watson Assistant.
 * 
 * Debido a como Watson Assistant devuelve la respuesta, es necesario crear esta clase
 * para poder deserializar la respuesta de Watson Assistant.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatsonAssistantOptionValueInput {
    private String text;

    public WatsonAssistantOptionValueInput() {}


    public WatsonAssistantOptionValueInput(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "WatsonAssistantOptionValueInput [text=" + text + "]";
    }
}
