package org.example.portcartierlibrarybackend.repository;

import org.example.portcartierlibrarybackend.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
