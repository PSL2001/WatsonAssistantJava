package com.viewnext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WatsonAssistantOptionValue {
    private WatsonAssistantOptionValueInput input;

    public WatsonAssistantOptionValue() {}

    public WatsonAssistantOptionValue(WatsonAssistantOptionValueInput input) {
        this.input = input;
    }

    public WatsonAssistantOptionValueInput getInput() {
        return input;
    }

    public void setInput(WatsonAssistantOptionValueInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "WatsonAssistantOptionValue [input=" + input + "]";
    }
}

