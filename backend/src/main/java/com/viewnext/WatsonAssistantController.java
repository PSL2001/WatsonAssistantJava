package com.viewnext;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WatsonAssistantController {

    private WatsonAssistantService watsonAssistantService;

    public WatsonAssistantController(WatsonAssistantService watsonAssistantService) {
        this.watsonAssistantService = watsonAssistantService;
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public ResponseEntity<WatsonAssistantMessage> send(@RequestParam("message") @RequestBody String message) {
        try {
            WatsonAssistantMessage response = watsonAssistantService.sendMessage(message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
