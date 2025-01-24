package org.example.portcartierlibrarybackend.repository;

import org.example.portcartierlibrarybackend.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
