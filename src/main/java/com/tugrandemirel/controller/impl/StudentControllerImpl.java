package com.tugrandemirel.controller.impl;

import com.tugrandemirel.controller.IStudentController;
import com.tugrandemirel.entities.Student;
import com.tugrandemirel.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentControllerImpl  implements IStudentController {
    @Autowired
    private IStudentService studentService;

    /** TODO: DTO kullanılacak **/
    @PostMapping(path = "/save")
    @Override
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}
