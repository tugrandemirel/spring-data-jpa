package com.tugrandemirel.services.impl;

import com.tugrandemirel.dto.DtoStudent;
import com.tugrandemirel.dto.DtoStudentIU;
import com.tugrandemirel.entities.Student;
import com.tugrandemirel.repository.StudentRepository;
import com.tugrandemirel.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    // store student
    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        DtoStudent responseStudent = new DtoStudent();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student newStudent = studentRepository.save(student);
        BeanUtils.copyProperties(newStudent, responseStudent);

        return responseStudent;
    }

    // all Students
    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> responseStudents = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllStudents();
        for (Student student : studentList) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            responseStudents.add(dtoStudent);
        }
        return responseStudents;
    }

    // get student by id
    @Override
    public DtoStudent getStudentById(Long id) {
        DtoStudent dtoStudent = new DtoStudent();
        Optional<Student> optionalStudent =  studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            BeanUtils.copyProperties(student, dtoStudent);
        }

        return dtoStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.delete(optionalStudent.get());
        }
    }

    // update student
    @Override
    public DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentIU) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstName(dtoStudentIU.getFirstName());
            student.setLastName(dtoStudentIU.getLastName());
            student.setBirthOfDate(dtoStudentIU.getBirthOfDate());
            Student updateStudent = studentRepository.save(student);

            DtoStudent dtoStudent =  new DtoStudent();

            BeanUtils.copyProperties(student, dtoStudent);

            return dtoStudent;
        }
//        Student student = getStudentById(id);
//        if (student != null) {
//            student.setFirstName(updateStudent.getFirstName());
//            student.setLastName(updateStudent.getLastName());
//            student.setBirthOfDate(updateStudent.getBirthOfDate());
//
//            return studentRepository.save(student);
//        }
        return null;
    }
}
