package com.example.Project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

