package com.viewnext;

import javax.websocket.Session;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
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

    WatsonAssistantMessage sendMessage(String message) {
        try {
            if (this.assistant == null) {
                this.assistant = connect();
                this.session = createSession(assistant);
            }
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(session.getSessionId());
            MessageInput input = new MessageInput.Builder().text(message).build();
            MessageOptions messageOptions = new MessageOptions.Builder().assistantId(config.getId()).sessionId(session.getSessionId()).input(input).build();
            MessageResponse messageResponse = assistant.message(messageOptions).execute().getResult();
            return mapper.readValue(messageResponse.toString(), WatsonAssistantMessage.class);
        } catch (JsonProcessingException e) {
            throw new Error("Error al mapear el mensaje de respuesta de Watson Assistant" + e.getMessage());
        }
    }
}
