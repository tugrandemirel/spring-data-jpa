package com.tugrandemirel.controller;

import com.tugrandemirel.entities.Student;

import java.util.List;

public interface IStudentController {
    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentById(Long id);

    public void deleteStudentById(Long id);

    public Student updateStudent(Long id, Student updateStudent);
}
