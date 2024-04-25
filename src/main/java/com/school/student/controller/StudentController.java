package com.school.student.controller;

import com.school.student.model.Student;
import com.school.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;
    //get all students
    //localhost:8080/students
@GetMapping("/students")
    public List<Student> getAllStudents()
    {
List<Student> students=repo.findAll();
        return students;

    }
    //get studentbyId
    @GetMapping("students/{id}")
    public Student getStudent(@PathVariable int id)
    {
 Student student=repo.findById(id).get();
 return student;
    }

    //Adding the data
    @PostMapping("/students/add")
    public void addStudent(@RequestBody Student student)
    {
        repo.save(student);
    }

    //UPDATE THE DATA
    @PutMapping("/students/update/{id}")
    public Student updateStudent(@PathVariable int id)
    {
        Student student=repo.findById(id).get();
        student.setName("ZAHEER");
        student.setCity("CHENNAI");
        repo.save(student);
        return student;
    }
    //Deleting data
    @DeleteMapping("/students/del/{id}")
    public void delStudent(@PathVariable int id)
    {
        Student student=repo.findById(id).get();
        repo.delete(student);

    }



}
