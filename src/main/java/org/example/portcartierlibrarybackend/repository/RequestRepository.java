package org.example.portcartierlibrarybackend.repository;

import org.example.portcartierlibrarybackend.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {
}
