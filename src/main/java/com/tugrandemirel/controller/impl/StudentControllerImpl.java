package com.tugrandemirel.controller.impl;

import com.tugrandemirel.controller.IStudentController;
import com.tugrandemirel.entities.Student;
import com.tugrandemirel.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentControllerImpl  implements IStudentController {

    @Autowired
    private IStudentService studentService;

    /** TODO: DTO kullanılacak **/

    // List Methodu
    @GetMapping(path = "/")
    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Store Method
    @PostMapping(path = "/save")
    @Override
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Show Method
    @GetMapping(path = "/list/{id}")
    @Override
    public Student getStudentById(@PathVariable Long id) {
        System.out.println(id);
        return studentService.getStudentById(id);
    }
}
