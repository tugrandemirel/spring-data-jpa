package com.tugrandemirel.repository;

import com.tugrandemirel.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // SoftDelete Query
    //@Query("from Student students where students.deletedAt is null")
    @Query(value = "SELECT * FROM spring_data_jpa.students WHERE deleted_at IS NULL", nativeQuery = true)
    List<Student> findAllStudents();
    //List<Student> findByDeletedAtIsNull();

}
