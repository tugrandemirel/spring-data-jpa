package com.tugrandemirel.services;

import com.tugrandemirel.dto.DtoStudent;
import com.tugrandemirel.dto.DtoStudentIU;
import com.tugrandemirel.entities.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU student);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Long id);

    public void deleteStudent(Long id);

    public DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentIU);
}
