package org.example.portcartierlibrarybackend.services;

import org.example.portcartierlibrarybackend.model.Member;
import org.example.portcartierlibrarybackend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    MemberRepository userRepository;

    public boolean createMember(String code, String name, String email, String password, String phoneNumber, String address) {
        Optional<Member> member = userRepository.findByCode(code);
        if (member.isPresent()) {
            return false;
        }else{
            Member newMember = new Member();
            newMember.setCode(code);
            newMember.setName(name);
            newMember.setEmail(email);
            newMember.setPassword(password);
            newMember.setPhoneNumber(phoneNumber);
            newMember.setAddress(address);
            userRepository.save(newMember);
            return true;
        }
    }
}
