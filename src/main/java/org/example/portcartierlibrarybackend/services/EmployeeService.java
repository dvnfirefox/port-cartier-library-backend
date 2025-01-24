package org.example.portcartierlibrarybackend.services;

import org.example.portcartierlibrarybackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository adminRepository;
}
