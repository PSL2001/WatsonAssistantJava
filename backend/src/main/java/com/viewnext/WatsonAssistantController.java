package com.viewnext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para el servicio de Watson Assistant.
 * La anotación @RestController indica que esta clase es un controlador REST.
 * La anotación @CrossOrigin permite peticiones desde cualquier origen.
 * La anotación @GetMapping indica que el método que la contiene responde a peticiones GET en la ruta /send con un parámetro "message" en la URL.
 * La anotación @RequestParam indica que el parámetro "message" es un parámetro de la URL.
 * La anotación @PostMapping indica que el método que la contiene responde a peticiones POST en la ruta /send.
 * La anotación @RequestBody indica que el parámetro "message" es un parámetro del cuerpo de la petición.
 */
@RestController
// Permitir peticiones desde cualquier origen
@CrossOrigin(origins = "*")
public class WatsonAssistantController {
    /**
     * Servicio de Watson Assistant.
     */
    private final WatsonAssistantService watsonAssistantService; // variable final para el servicio de Watson Assistant
    /**
     * Constructor de la clase.
     * Inyecta el servicio de Watson Assistant.
     * @param watsonAssistantService
     */
    public WatsonAssistantController(WatsonAssistantService watsonAssistantService) {
        this.watsonAssistantService = watsonAssistantService;
    }

    /**
     * Método que responde a peticiones GET en la ruta /send con un parámetro "message" en la URL.
     * @param message
     * @return
     */
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
