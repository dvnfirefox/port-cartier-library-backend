package org.example.portcartierlibrarybackend.repository;

import org.example.portcartierlibrarybackend.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByCode(String code);
}
