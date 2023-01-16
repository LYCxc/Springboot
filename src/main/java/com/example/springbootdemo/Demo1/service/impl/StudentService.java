package com.example.springbootdemo.Demo1.service.impl;

import com.example.springbootdemo.Demo1.pojo.dto.StudentResponseDTO;
import com.example.springbootdemo.Demo1.pojo.entity.Student;
import com.example.springbootdemo.Demo1.repository.StudentRepository;
import com.example.springbootdemo.Demo1.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface  {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStu() {
        List<Student> list=null;
        try
        {
            list=studentRepository.findAll();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return  list;
    }

    @Override
    public Student getStuById(Integer Id) {
        Student student=null;
        try
        {
            student=studentRepository.findStuById(Id);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return student;
    }

    @Override
    public Student getStuByName(String Name) {
       Student student=null;
        try
        {
            student=studentRepository.findStudentByName(Name);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return  student;
    }
   @Override
    public  void saveStudent(Student stu)
   {
       studentRepository.save(stu);
   }

    @Override
    public void UpdateStuByName(String name, String age) {
        studentRepository.queryStudentByName(name,age);
    }

    @Override
    public void DeleteStuByName(String name) {
        studentRepository.deleteStuByName(name);
    }


}
