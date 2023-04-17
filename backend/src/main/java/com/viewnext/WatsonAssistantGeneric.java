package com.viewnext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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


