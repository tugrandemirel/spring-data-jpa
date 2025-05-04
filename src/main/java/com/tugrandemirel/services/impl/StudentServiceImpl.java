package com.tugrandemirel.services.impl;

import com.tugrandemirel.entities.Student;
import com.tugrandemirel.repository.StudentRepository;
import com.tugrandemirel.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
