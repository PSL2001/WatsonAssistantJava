package com.viewnext;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.SessionResponse;

/*  
 * Servicio de Watson Assistant.
 * Este servicio se encarga de conectarse con el servicio de Watson Assistant y enviarle mensajes.
 * El servicio de Watson Assistant devuelve una respuesta que se devuelve al cliente.
 * El servicio de Watson Assistant se conecta con el servicio de Watson Assistant mediante la API REST.
 */
@Service
public class WatsonAssistantService {
    /**
     * Configuración de Watson Assistant.
     * Esta configuración se inyecta mediante el constructor.
     * La configuración contiene el API Key y el ID del asistente.
     * El API Key se utiliza para autenticarse con el servicio de Watson Assistant.
     * El ID del asistente se utiliza para identificar el asistente con el que se quiere conectar.
     */
    private final WatsonAssistantConfig config;
    /**
     * Sesión con el servicio de Watson Assistant.
     * Una sesión es un contexto que se mantiene entre las peticiones de un cliente.
     * Por ejemplo, si el cliente envía una petición con el mensaje "Quiero reservar una habitación para dos personas",
     * el servicio de Watson Assistant puede devolver una respuesta con el mensaje "¿Cuándo quieres reservar la habitación?".
     * La respuesta contiene un contexto que indica que el cliente quiere reservar una habitación para dos personas.
     * 
     * La sesión se crea al conectarse con el servicio de Watson Assistant y dependiendo del plan que se utilice,
     * la sesión tiene un tiempo de vida.
     * Por ejemplo, si el plan es "Lite", la sesión tiene un tiempo de vida de 5 minutos.
     * Si el cliente envía una petición con el mensaje "Quiero reservar una habitación para dos personas" y la sesión
     * se ha creado hace 10 minutos, el servicio de Watson Assistant no devolverá una respuesta con el mensaje
     */
    private SessionResponse session;
    /**
     * Assistant de Watson Assistant.
     * El Assistant se utiliza para crear una sesión y enviar mensajes, basándose en la configuración.
     * El Assistant se crea al conectarse con el servicio de Watson Assistant.
     * El Assistant se utiliza para crear una sesión y enviar mensajes.
     */
    private Assistant assistant;

    /*  
     * Constructor con inyección de dependencias de la configuración de Watson Assistant.
     * La configuración de Watson Assistant se inyecta mediante el constructor.
     * La configuración contiene el API Key y el ID del asistente.
     * @param config Configuración de Watson Assistant.
     */
    public WatsonAssistantService(WatsonAssistantConfig config) {
        this.config = config;
    }
    /*  
     * Crea una sesión con el servicio de Watson Assistant.
     * Una sesión es un contexto que se mantiene entre las peticiones de un cliente.
     * Por ejemplo, si el cliente envía una petición con el mensaje "Quiero reservar una habitación para dos personas",
     * el servicio de Watson Assistant puede devolver una respuesta con el mensaje "¿Cuándo quieres reservar la habitación?".
     * @param service Servicio de Watson Assistant.
     */
    private SessionResponse createSession(Assistant service){
        CreateSessionOptions createSessionOptions = new CreateSessionOptions.Builder(config.getId()).build();
        return service.createSession(createSessionOptions).execute().getResult();
    }
    /*  
     * Conecta con el servicio de Watson Assistant.
     * El servicio de Watson Assistant se conecta con el servicio de Watson Assistant mediante la API REST.
     */
    private Assistant connect() {
        try {
            Authenticator authenticator = new IamAuthenticator.Builder().apikey(config.getApikey()).build();
            Assistant service = new Assistant(config.getVersion(), authenticator);
            service.setServiceUrl(config.getUrl());
            //Creamos sesion
            return service;
        } catch (Error e) {
            throw new Error("Error al conectar con el servicio de Watson Assistant: " + e.getMessage());
        }
    }
    /*  
     * Envía un mensaje al servicio de Watson Assistant.
     * El servicio de Watson Assistant devuelve una respuesta que se devuelve al cliente.
     * @param message Mensaje que se envía al servicio de Watson Assistant.
     */
    public WatsonAssistantMessage sendMessage(String message) {
        try {
            // Si no hay sesión, la creamos
            if (assistant == null) {
                assistant = connect();
                session = createSession(assistant);
            }
            // Enviamos mensaje
            ObjectMapper mapper = new ObjectMapper();
            // Creamos mensaje
            MessageInput input = new MessageInput.Builder().text(message).build();
            // Creamos opciones de mensaje con el mensaje y la sesión
            MessageOptions messageOptions = new MessageOptions.Builder().assistantId(config.getId()).sessionId(session.getSessionId()).input(input).build();
            // Enviamos mensaje y obtenemos respuesta
            MessageResponse messageResponse = assistant.message(messageOptions).execute().getResult();
            // Devolvemos respuesta
            return mapper.readValue(messageResponse.toString(), WatsonAssistantMessage.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar mensaje a Watson Assistant: " + e.getMessage());
        }
    }
}
