package org.example.portcartierlibrarybackend.services;

import org.example.portcartierlibrarybackend.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    userRepository userRepository;
}
