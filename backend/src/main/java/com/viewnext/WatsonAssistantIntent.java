package com.viewnext;

/*
 * Representa un mensaje devuelto por el servicio de Watson Assistant.
 * Principalmente, un mensaje es un objeto que contiene información sobre la intención y las entidades
 * del usuario.
 * Por ejemplo, en la oración "Quiero reservar una habitación para dos personas",
 * el mensaje puede contener la intención "reservar" y la entidad "personas" con el valor "dos".
 */
public class WatsonAssistantIntent {
    /**
     * Intención del mensaje.
     * Por ejemplo, "reservar".
     */
    private String intent;
    /**
     * Confianza de la intención.
     * Por ejemplo, 0.9.
     */
    private double confidence;

    // Getters and setters
    /**
     * Devuelve la intención del mensaje.
     * @return intent
     */
    public String getIntent() {
        return intent;
    }
    /**
     * Establece la intención del mensaje.
     * @param intent
     */
    public void setIntent(String intent) {
        this.intent = intent;
    }
    /**
     * Devuelve la confianza de la intención.
     * @return confidence
     */
    public double getConfidence() {
        return confidence;
    }
    /**
     * Establece la confianza de la intención.
     * @param confidence
     */
    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
