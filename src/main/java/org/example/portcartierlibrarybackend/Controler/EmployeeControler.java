package org.example.portcartierlibrarybackend.Controler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.portcartierlibrarybackend.model.Employee;
import org.example.portcartierlibrarybackend.repository.DocumentRepository;
import org.example.portcartierlibrarybackend.services.DocumentService;
import org.example.portcartierlibrarybackend.services.EmployeeService;
import org.example.portcartierlibrarybackend.tools.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeControler {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DocumentService documentService;

    @PostMapping("createdocument")
    public ObjectNode CreateDocument(@RequestBody String json) {
        ObjectNode response = Json.createNode();
        try{
            JsonNode document = Json.toJson(json);
            String author = document.get("author").asText();
            String category = document.get("category").asText();
            String date = document.get("date").asText();
            String description = document.get("description").asText();
            String genre = document.get("genre").asText();
            String title = document.get("title").asText();
            String type = document.get("type").asText();
            String ISBM = document.get("ISBM").asText();
            if(documentService.createDocument(author, category, date, description, genre, title, type, ISBM)){
                response.put("message","Document " + title + " successfully created");
            }else{
                response.put("message", "the document " + title + " could not be created");
            }
        }catch (Exception e){
            response.put("message", e.getMessage());

        }
        return response;
    }
    @GetMapping("reportDocument")
    public ObjectNode ReportDocument() {
        return documentService.allDocument();
    }
}
