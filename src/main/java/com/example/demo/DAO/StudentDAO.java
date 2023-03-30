package com.example.demo.DAO;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDAO {
    private final StudentRepository _StudentRepository;

    public StudentDAO(StudentRepository studentRepository) {
        _StudentRepository = studentRepository;
    }

    public List<Student> getAllStudent(){
        return _StudentRepository.findAll();
    }





}
