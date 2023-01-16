package com.example.springbootdemo.Demo1.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
public class StudentResponseDTO {
    private List<StudentDTO> studentList;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public  static  class StudentDTO{
        private String name;
        private String age;

    }
}
