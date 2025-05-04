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
      /*Optional<Student> student = studentRepository.findById(id);
           if (student.isEmpty()) {
               return null;
           }
           return student.get();*/
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        if (student != null) {
            studentRepository.delete(student);
        }
    }

    // update student
    @Override
    public Student updateStudent(Long id, Student updateStudent) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setFirstName(updateStudent.getFirstName());
            student.setLastName(updateStudent.getLastName());
            student.setBirthOfDate(updateStudent.getBirthOfDate());

            return studentRepository.save(student);
        }

        return null;
    }
}
