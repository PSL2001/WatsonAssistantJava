package com.viewnext;

import javax.websocket.Session;

import org.springframework.stereotype.Service;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.SessionResponse;

@Service
public class WatsonAssistantService {
    private WatsonAssistantConfig config;
    private SessionResponse session;
    private Assistant assistant;

    public WatsonAssistantService(WatsonAssistantConfig config) {
        this.config = config;
    }

    private SessionResponse createSession(Assistant service){
        CreateSessionOptions createSessionOptions = new CreateSessionOptions.Builder(config.getId()).build();
        return service.createSession(createSessionOptions).execute().getResult();
    }

    private Assistant connect() {
        try {
            Authenticator authenticator = new IamAuthenticator.Builder().apikey(config.getApikey()).build();
            Assistant service = new Assistant(config.getVersion(), authenticator);
            service.setServiceUrl(config.getUrl());
            //Creamos sesion
            return service;
        } catch (Error e) {
            throw new Error("Error al conectar con el servicio de Watson Assistant" + e.getMessage());
        }
    }
}
