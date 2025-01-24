package org.example.portcartierlibrarybackend.Controler;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.example.portcartierlibrarybackend.services.MemberService;
import org.example.portcartierlibrarybackend.tools.Json;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class AdminControlerTest {

    @Test
    void testCreateMember(){
        var admin = new AdminControler();
        MemberService mockMember = Mockito.mock(MemberService.class);
        ReflectionTestUtils.setField(admin, "memberService", mockMember);
        when(mockMember.createMember(anyString(), anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn(true);
        ObjectNode test = Json.createNode();
        test.put("code","1234");
        test.put("password","123456");
        test.put("name","test");
        test.put("address","test");
        test.put("email","test@example.com");
        test.put("phone","123456789");

        ObjectNode output = Json.createNode();
        output.put("status",true);
        output.put("message","client 1234 created successfully");

        assertEquals(output,admin.createMember(test.toString()));
    }
    @Test
    void testCreateMemberExist(){
        var admin = new AdminControler();
        MemberService mockMember = Mockito.mock(MemberService.class);
        ReflectionTestUtils.setField(admin, "memberService", mockMember);
        when(mockMember.createMember(anyString(), anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn(false);
        ObjectNode test = Json.createNode();
        test.put("code","1234");
        test.put("password","123456");
        test.put("name","test");
        test.put("address","test");
        test.put("email","test@example.com");
        test.put("phone","123456789");

        ObjectNode output = Json.createNode();
        output.put("status",false);
        output.put("message","client 1234 already exist");

        assertEquals(output,admin.createMember(test.toString()));
    }


}
