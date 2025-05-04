package com.tugrandemirel.controller;

import com.tugrandemirel.dto.DtoStudent;
import com.tugrandemirel.dto.DtoStudentIU;
import com.tugrandemirel.entities.Student;

import java.util.List;

public interface IStudentController {
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Long id);

    public void deleteStudentById(Long id);

    public DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentIU);
}
