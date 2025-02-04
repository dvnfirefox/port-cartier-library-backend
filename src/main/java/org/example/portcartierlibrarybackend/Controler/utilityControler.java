package org.example.portcartierlibrarybackend.Controler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.portcartierlibrarybackend.repository.DocumentRepository;
import org.example.portcartierlibrarybackend.services.DocumentService;
import org.example.portcartierlibrarybackend.tools.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class utilityControler {
    @Autowired
    private DocumentService documentService;

    @PostMapping("documentlisting")
    public ObjectNode getDocumentListin(@RequestBody String json) {
        ObjectNode response = Json.createNode();
        try{
            JsonNode node = Json.toJson(json);
            String keyword = node.get("keyword").asText();
            String type = node.get("type").asText();
            response = documentService.searchDocument(keyword, type);

        }catch (Exception e){
            response.put("error", e.getMessage());
        }
        return response;
    }

    @PostMapping("getdocument")
    public ObjectNode getDocument(@RequestBody String idRequest) {

        ObjectNode response = Json.createNode();

        try{
            JsonNode node = Json.toJson(idRequest);
            Long id = Long.parseLong(node.get("id").asText());
            System.out.println(id);
            response = documentService.getDocument(id);
        }catch (Exception e){
            response.put("error", e.getMessage());
        }
        return response;
    }

}
