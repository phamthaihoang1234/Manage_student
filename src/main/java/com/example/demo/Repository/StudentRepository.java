package com.example.demo.Repository;

import com.example.demo.Entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    public List<Student> findAll();

    @Query(value = "select * from student where studentId = :id", nativeQuery = true)
    public Student findStudentById(@Param("id") int id);
}
