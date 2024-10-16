package com.example.Employee.Controller;

import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> getAll(){
        return employeeService.getAll();
    }

    @PutMapping("/update/{id}")
    public void updateEmployee(@PathVariable int id,@RequestBody Employee e){
         employeeService.updateEmployee(id,e);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }

}
