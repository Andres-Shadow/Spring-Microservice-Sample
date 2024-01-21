package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.serviceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Course course = courseService.findById(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudents(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/search-students/{courseid}")
    public ResponseEntity<?> findStudentsByCourseId(@PathVariable Long courseid){
        return ResponseEntity.ok(courseService.findStudentsByCourseId(courseid));

    }

}
