package com.viewnext;

/*
 * Representa un mensaje devuelto por el servicio de Watson Assistant.
 * Principalmente, un mensaje es un objeto que contiene información sobre la intención y las entidades
 * del usuario.
 * Por ejemplo, en la oración "Quiero reservar una habitación para dos personas",
 * el mensaje puede contener la intención "reservar" y la entidad "personas" con el valor "dos".
 */
public class WatsonAssistantIntent {

    private String intent;
    private double confidence;

    // Getters and setters
    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
