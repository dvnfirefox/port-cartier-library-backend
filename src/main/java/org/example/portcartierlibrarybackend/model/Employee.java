package org.example.portcartierlibrarybackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String password;
    private boolean admin;

    public Employee(){}
    public Employee(String code, String password, boolean admin) {
        this.code = code;
        this.password = password;
        this.admin = admin;
    }
}

