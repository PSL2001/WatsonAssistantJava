package com.viewnext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * WatsonAssistantOption
 * Esta clase representa una opción de respuesta de Watson Assistant.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatsonAssistantOption {
    /**
     * label
     * Etiqueta de la opción. Esto es lo que se muestra al usuario.
     */
    private String label;
    /**
     * value
     * Valor de la opción. Esto es lo que se envía al servidor.
     */
    private WatsonAssistantOptionValue value;
    /**
     * Metodo getLabel
     * @return label
     */
    public String getLabel() {
        return label;
    }
    /**
     * Metodo setLabel
     * @param label La etiqueta de la opción. Contiene el texto que se muestra al usuario.
     */
    public void setLabel(String label) {
        this.label = label;
    }
    /**
     * Metodo getValue
     * @return value
     */
    public WatsonAssistantOptionValue getValue() {
        return value;
    }
    /**
     * Metodo setValue
     * @param value El valor de la opción. Contiene un input dentro el cual se manda al servidor.
     */
    public void setValue(WatsonAssistantOptionValue value) {
        this.value = value;
    }
    /**
     * Metodo toString
     * @return String
     */
    @Override
    public String toString() {
        return "WatsonAssistantOption [label=" + label + ", value=" + value + "]";
    }
}


