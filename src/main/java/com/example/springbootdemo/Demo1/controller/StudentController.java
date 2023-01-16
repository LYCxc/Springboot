package com.example.springbootdemo.Demo1.controller;

import com.example.springbootdemo.Demo1.StudentApplication;
import com.example.springbootdemo.Demo1.pojo.dto.StudentResponseDTO;
import com.example.springbootdemo.Demo1.pojo.entity.Student;
import com.example.springbootdemo.Demo1.service.impl.StudentService;
import com.sun.source.tree.TryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Student 控制层
 */
@RestController
@RequestMapping("/index")
public class StudentController {
    StudentService studentService;
    @Autowired
    public  void setStudentService(StudentService studentService)
    {
       this.studentService=studentService;
    }

    @RequestMapping()
    @ResponseBody
     public List<Student> getAll()
     {
         List<Student> list=null;
         try{
             list=studentService.getAllStu();
         }
         catch (Exception e){}
         return  list;
     }


    @GetMapping("/{id}")
    public  ResponseEntity<Student> getStuById(@PathVariable Integer id)
    {
        Student returnstu=studentService.getStuById(id);
        return  new ResponseEntity<>(returnstu,HttpStatus.OK);
    }


    @GetMapping("/getName/{name}")
    @ResponseBody
    public ResponseEntity<Student> getStuByName(@PathVariable String name)
    {   Student StuDTO=studentService.getStuByName(name);
        return new ResponseEntity<>(StuDTO,HttpStatus.OK);
    }

    @RequestMapping(value = "/Insert",method = RequestMethod.POST)
    @ResponseBody
    public String CreateStu(@RequestParam("name") String name,@RequestParam("Age") String age)
    {
        Student student=new Student();
        student.setAge(age);
        student.setName(name);
        try
        {
            studentService.saveStudent(student);
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
        return "Success";
    }
    @RequestMapping(value = "/Update",method = RequestMethod.POST)
    @ResponseBody
    public String UpdatetStuByName(@RequestParam("name")String name,@RequestParam("Age")String age)
    {
        Student student=new Student();

        try
        {
           studentService.UpdateStuByName(name,age);
        }
        catch (Exception e)
        {
            return  e.getMessage();
        }
        return  "Success";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public  String DeleteStuByName(@RequestParam("name")String name)
    {
        Student student=new Student();

        try
        {
            studentService.DeleteStuByName(name);
        }
        catch (Exception e)
        {
            return  e.getMessage();
        }
        return  "Success";
    }




}
