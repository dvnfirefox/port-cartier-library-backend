package org.example.portcartierlibrarybackend.Controler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.portcartierlibrarybackend.services.DocumentService;
import org.example.portcartierlibrarybackend.tools.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberControler {
    @Autowired
    DocumentService documentService;

    @PostMapping("requestdocument")
    public ObjectNode requestDocument(@RequestBody String json) {
        ObjectNode response = Json.createNode();
        try{
            JsonNode node = Json.toJson(json);
            Long id = Long.parseLong(node.get("id").asText());
            String memberId = node.get("memberCode").asText();
            documentService.requestDocument(id, memberId);
            response.put("success", true);

        } catch (JsonProcessingException e) {
            response.put("error", e.getMessage());
        }
        return response;
    }
}
