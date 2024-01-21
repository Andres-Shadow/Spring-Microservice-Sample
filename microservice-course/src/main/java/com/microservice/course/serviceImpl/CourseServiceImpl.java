package com.microservice.course.serviceImpl;

import com.microservice.course.entities.Course;
import com.microservice.course.persistence.CourseRepository;
import com.microservice.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepo;
    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Course course) {
        courseRepo.save(course);
    }
}
