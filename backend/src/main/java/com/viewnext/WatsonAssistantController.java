package com.viewnext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class WatsonAssistantController {

    private WatsonAssistantService watsonAssistantService;

    @Autowired
    public WatsonAssistantController(WatsonAssistantService watsonAssistantService) {
        this.watsonAssistantService = watsonAssistantService;
    }
    
    @RequestMapping(value="/send", method = RequestMethod.GET)
    public JsonNode send(@RequestParam("message") String message) throws JsonProcessingException {

        //String response1 = watsonAssistantService.sendMessage("Hola");
        WatsonAssistantMessage response;
        response = watsonAssistantService.sendMessage(message);

        return response.getGeneric();

    }
}
