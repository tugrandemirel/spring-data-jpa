package com.tugrandemirel.services.impl;

import com.tugrandemirel.entities.Student;
import com.tugrandemirel.repository.StudentRepository;
import com.tugrandemirel.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    // store student
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // all Students
    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    // get student by id
    @Override
    public Student getStudentById(Long id) {
       try {
           /*Optional<Student> student = studentRepository.findById(id);
           if (student.isEmpty()) {
               return null;
           }
           return student.get();*/
           return studentRepository.findById(id).orElse(null);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}
