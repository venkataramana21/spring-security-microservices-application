package com.example.Interview.Fegin;

import com.example.Interview.Dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Employee",url = "http://localhost:9090/employee")
public interface EmployeeInterface {
    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id);

    @GetMapping("getall")
    public ResponseEntity<List<Employee>> getAll();
}
