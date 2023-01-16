package com.example.springbootdemo.Demo1.repository;

import com.example.springbootdemo.Demo1.pojo.dto.StudentResponseDTO;
import com.example.springbootdemo.Demo1.pojo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    /**
     * get student info by name
     * @param name
     * @return
     */
    @Query("select  t from Student t where t.Name=:name")
    Student findStudentByName(@Param("name") String name);

    /**
     * get all students info
     * @return
     */
    @Query("select t from  Student t")
    List<Student> findAll();

    /**
     * Delete student info by id
     * @param id
     * @return
     */

    @Query("select t from Student t where t.Stdid=:id")
    Student findStuById(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("delete  from  Student t where  t.Name=:name")
    public  int deleteStuByName(@Param("name")String name);
    @Modifying
    @Transactional
    @Query("update Student s set s.Age=:age where s.Name=:name")
    public  int queryStudentByName(@Param("name") String name, @Param("age") String age);
}
