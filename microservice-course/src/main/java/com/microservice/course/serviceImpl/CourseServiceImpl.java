package com.microservice.course.serviceImpl;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDto;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.persistence.CourseRepository;
import com.microservice.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private StudentClient studentClient;

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

    @Override
    public StudentsByCourseResponse findStudentsByCourseId(Long courseId) {
        //search for course
        Course course = courseRepo.findById(courseId).orElse(null);
        //obtain students by course
        List<StudentDto> studentDtoList = studentClient.findAllStudentByCourse(courseId);
        return StudentsByCourseResponse.builder()
                .name(course.getName())
                .teacher(course.getTeacher())
                .studentsDtoList(studentDtoList)
                .build();

    }
}
