package com.example.Project.Dto;

import com.example.Project.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Res {
    Project p;
    List<Response> responseList;
}
