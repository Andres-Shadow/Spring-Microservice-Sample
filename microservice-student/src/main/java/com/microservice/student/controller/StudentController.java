package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.servicesImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Student student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudents(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findCourseById(@PathVariable Long idCourse){
        return ResponseEntity.ok(studentService.findAllByCourseID(idCourse));
    }
}
