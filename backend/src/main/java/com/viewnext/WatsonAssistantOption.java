package com.viewnext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WatsonAssistantOption {
    private String label;
    private WatsonAssistantOptionValue value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public WatsonAssistantOptionValue getValue() {
        return value;
    }

    public void setValue(WatsonAssistantOptionValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "WatsonAssistantOption [label=" + label + ", value=" + value + "]";
    }
}


