package com.example.storage4pratica2.service;

import com.example.storage4pratica2.data.ES.EmployeeRepository;
import com.example.storage4pratica2.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        employee.setId(null);
        return employeeRepository.save(employee);
    }

    public Employee update(String id, Employee employee) {
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }

    public Employee findById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}


