package com.microservice.student.servicesImpl;

import com.microservice.student.entities.Student;
import com.microservice.student.persistence.StudentRepository;
import com.microservice.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepo;
    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<Student> findAllByCourseID(Long courseID) {
        return studentRepo.findAllByCourseID(courseID);
    }
}
