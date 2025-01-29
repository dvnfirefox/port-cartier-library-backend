package org.example.portcartierlibrarybackend.services;

import org.example.portcartierlibrarybackend.model.Employee;
import org.example.portcartierlibrarybackend.model.Member;
import org.example.portcartierlibrarybackend.repository.EmployeeRepository;
import org.example.portcartierlibrarybackend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository EmployeeRepository;
    @Autowired
    MemberRepository memberRepository;

    public boolean createEmployee(String code, String password, boolean admin) {
        Optional<Employee> employee = EmployeeRepository.findByCode(code);
        Optional<Member> member = memberRepository.findByCode(code);
        if (employee.isEmpty() && member.isEmpty()) {
            Employee newEmployee = new Employee();
            newEmployee.setCode(code);
            newEmployee.setPassword(password);
            newEmployee.setAdmin(admin);
            EmployeeRepository.save(newEmployee);
            return true;
        }else{
            return false;
        }
    }
    public boolean employeeLogging(String code, String password) {
        Optional<Employee> employee = EmployeeRepository.findByCode(code);
        return employee.isPresent() && employee.get().getPassword().equals(password);
    }
    public boolean isAdmin(String code) {
        Optional<Employee> employee = EmployeeRepository.findByCode(code);
        return employee.isPresent() && employee.get().isAdmin();
    }
}
