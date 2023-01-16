package com.example.springbootdemo.Demo1.service;

import com.example.springbootdemo.Demo1.pojo.dto.StudentResponseDTO;
import com.example.springbootdemo.Demo1.pojo.entity.Student;
import com.example.springbootdemo.Demo1.service.impl.StudentService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentServiceInterface {
    List<Student> getAllStu();
    Student getStuById(Integer Id);
    Student getStuByName(@Param("name") String Name);
    void saveStudent(Student stu);
    void UpdateStuByName(String name, String age);
    void DeleteStuByName(String name);
}
