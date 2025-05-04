package com.tugrandemirel.controller.impl;

import com.tugrandemirel.controller.IStudentController;
import com.tugrandemirel.dto.DtoStudent;
import com.tugrandemirel.dto.DtoStudentIU;
import com.tugrandemirel.entities.Student;
import com.tugrandemirel.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;


    // List Methodu
    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Store Method
    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIu) {
        return studentService.saveStudent(dtoStudentIu);
    }

    // Show Method
    @GetMapping(path = "/list/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable Long id ,@RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.updateStudent(id, dtoStudentIU);
    }
}
