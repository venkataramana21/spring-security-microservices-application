package com.example.Employee.service;

import com.example.Employee.model.Employee;
import com.example.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseEntity<Employee> addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);

    }

    public ResponseEntity<Employee> getEmployee(int id) {
        Employee e=employeeRepository.findById(id).get();
        return new ResponseEntity<>(e, HttpStatus.OK);

    }

    public ResponseEntity<List<Employee>> getAll() {
        List<Employee>l=employeeRepository.findAll();
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    public void updateEmployee(int id,Employee e) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            employeeRepository.save(e);
        }

    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
