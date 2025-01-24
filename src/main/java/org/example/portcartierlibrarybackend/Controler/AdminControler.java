package org.example.portcartierlibrarybackend.Controler;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.portcartierlibrarybackend.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.example.portcartierlibrarybackend.tools.Json;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminControler {

    @Autowired
    private MemberService memberService;

    @PostMapping("createMember")
    public ObjectNode createMember(@RequestBody String json){
        ObjectNode response = Json.createNode();
        try{
            JsonNode node = Json.toJson(json);
            String code = node.get("code").asText();
            String password = node.get("password").asText();
            String name = node.get("name").asText();
            String address = node.get("address").asText();
            String email = node.get("email").asText();
            String phone = node.get("phone").asText();
            if(memberService.createMember(code,name,email,password,phone,address)){
                response.put("status",true);
                String message = "client " + code + " created successfully";
                response.put("message",message);
            }else{
                response.put("status",false);
                String message = "client " + code + " already exist";
                response.put("message",message);
            }
        }catch (Exception e){
            response.put("error", e.getMessage());
        }

        return response;
    }
    }
