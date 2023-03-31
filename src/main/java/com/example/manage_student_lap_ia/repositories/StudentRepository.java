package com.example.manage_student_lap_ia.repositories;

import com.example.manage_student_lap_ia.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    public Long countStudentById(Integer id);

    @Query(value = "select * from students where status = 1", nativeQuery = true)
    public List<Student> getAllActive();
}
