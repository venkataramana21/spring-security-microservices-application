package com.example.Interview.Service;

import com.example.Interview.Dto.Employee;
import com.example.Interview.Dto.Response;
import com.example.Interview.Fegin.EmployeeInterface;
import com.example.Interview.Repository.InterviewRepository;
import com.example.Interview.model.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewService {

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    EmployeeInterface employeeInterface;

    public ResponseEntity<Interview> createInterView(Interview interview) {
        interviewRepository.save(interview);
        return new ResponseEntity<>(interview, HttpStatus.CREATED);
    }

    public ResponseEntity<Interview> getById(int id) {
        Interview i=interviewRepository.findById(id).get();
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    public ResponseEntity<List<Interview>> getAll() {
        List<Interview>l=interviewRepository.findAll();
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    public ResponseEntity<List<Interview>> getPassedInterview(String status) {
        List<Interview> l=interviewRepository.findByStatusEqualsPASSED(status);
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    public ResponseEntity<List<Response>> getSelectedEmployeeDetails() {
        List<Response>res=new ArrayList<>();
        List<Interview>l=interviewRepository.findByStatusEqualsPASSED("Passed");
        System.out.println(l);
        for(Interview i :l){
            Response r=new Response();
            int id= Integer.parseInt(i.getEmpid());
            Employee e=employeeInterface.getEmployee(id).getBody();
            r.setEmpid(e.getEmpid());
            r.setEmpname(e.getEmpname());
            r.setExp(e.getExp());
            r.setTech(e.getTech());
            r.setInterview(i);
            res.add(r);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);

    }
}
