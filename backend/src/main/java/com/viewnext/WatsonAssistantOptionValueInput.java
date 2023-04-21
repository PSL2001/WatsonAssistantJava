package com.viewnext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
