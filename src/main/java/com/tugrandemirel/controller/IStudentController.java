package com.tugrandemirel.controller;

import com.tugrandemirel.entities.Student;

import java.util.List;

public interface IStudentController {
    public Student saveStudent(Student student);

    public List<Student> getAllStudents();
}
