package org.example.portcartierlibrarybackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Request {
    @Id
    @GeneratedValue
    private Long id;
    private String clientCode;
    private String documentCode;
    private Date requestDate;
}
