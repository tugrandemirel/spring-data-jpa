package com.tugrandemirel.services;

import com.tugrandemirel.entities.Student;

import java.util.List;

public interface IStudentService {
    public Student saveStudent(Student student);

    public List<Student> getAllStudents();
}
