package org.example.portcartierlibrarybackend.Controler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.portcartierlibrarybackend.services.EmployeeService;
import org.example.portcartierlibrarybackend.services.MemberService;
import org.example.portcartierlibrarybackend.tools.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingControler {
    @Autowired
    private MemberService memberService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/logging")
    public ObjectNode logging(@RequestBody String json ){
        ObjectNode response = Json.createNode();
        try{
            JsonNode node = Json.toJson(json);
            String code = node.get("code").asText();
            String password = node.get("password").asText();

            if (memberService.memberLogging(code, password)) {
                response.put("logged", true);
                response.put("message", "Logged successfully");
                response.put("code", code);
                response.put("employee", false);
                response.put("admin", false);
            } else if (employeeService.employeeLogging(code, password)) {
                response.put("logged", true);
                response.put("message", "Logged successfully");
                response.put("code", code);
                response.put("employee", true);
                response.put("admin", employeeService.isAdmin(code));
            } else {
                response.put("logged", false);
                response.put("message", "Invalid credentials");
            }
        }catch (Exception e){

            response.put("error", e.getMessage());
        }

        return response;
    }


}
