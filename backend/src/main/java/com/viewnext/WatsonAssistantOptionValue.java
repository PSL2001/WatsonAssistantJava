package com.viewnext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * WatsonAssistantOptionValue
 * Esta clase representa el valor de una opción de respuesta de Watson Assistant.
 * El valor de una opción es el texto que se envía al servidor cuando el usuario
 * selecciona una opción.
 * Esta clase se utiliza en la clase WatsonAssistantOption cuando se recibe una
 * respuesta de Watson Assistant.
 * 
 * Ejemplo de respuesta de Watson Assistant:
 * {
 *  "output": {
 *     "generic": [
 *      {
 *       "response_type": "option",
 *      "title": "¿Qué quieres hacer?",
 *     "options": [
 *     {
 *     "label": "Ver el menú",
 *    "value": {
 *   "input": {
 * "text": "Ver el menú"
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatsonAssistantOptionValue {
    /**
     * input
     * Valor de la opción. Esto es lo que se envía al servidor.
     */
    private WatsonAssistantOptionValueInput input;

    public WatsonAssistantOptionValue() {}
    /**
     * Constructor
     * @param input Valor de la opción. Esto es lo que se envía al servidor.
     */
    public WatsonAssistantOptionValue(WatsonAssistantOptionValueInput input) {
        this.input = input;
    }
    /**
     * Metodo getInput
     * @return input
     */
    public WatsonAssistantOptionValueInput getInput() {
        return input;
    }
    /**
     * Metodo setInput
     * @param input Valor de la opción. Esto es lo que se envía al servidor.
     */
    public void setInput(WatsonAssistantOptionValueInput input) {
        this.input = input;
    }
    /**
     * Metodo toString
     * @return String
     */
    @Override
    public String toString() {
        return "WatsonAssistantOptionValue [input=" + input + "]";
    }
}

