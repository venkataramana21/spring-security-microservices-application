package com.example.Interview.Dto;

import com.example.Interview.model.Interview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private int empid;
    private String empname;
    private String tech;
    private int exp;
    Interview interview;
}
