package com.viewnext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200") // permite el acceso al origen http://localhost:4200
public class WatsonAssistantController {

    private final WatsonAssistantService watsonAssistantService; // variable final para el servicio de Watson Assistant

    // constructor con inyección de dependencias del servicio de Watson Assistant
    public WatsonAssistantController(WatsonAssistantService watsonAssistantService) {
        this.watsonAssistantService = watsonAssistantService;
    }

    // mapeo de la solicitud GET en /send con un parámetro "message" en la URL
    @GetMapping("/send")
    public ResponseEntity<WatsonAssistantMessage> send(@RequestParam String message) {
        try {
            WatsonAssistantMessage response = watsonAssistantService.sendMessage(message);
            System.out.println("Respuesta de Watson Assistant: " + response.getOutput().toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            // si se produce una excepción, devolver un error del servidor interno
            //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            throw new Error("Error al enviar el mensaje al servicio de Watson Assistant: " + e.getMessage());
        }
    }

}
