package com.example.manage_student_lap_ia.services;


import com.example.manage_student_lap_ia.entities.Student;
import com.example.manage_student_lap_ia.entities.UserNotFoundException;
import com.example.manage_student_lap_ia.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentRepository repo;




    public List<Student> listAll() {
        return repo.getAllActive();
    }

    public void save(Student student) {
        repo.save(student);
    }

    public Student get(Integer id) throws UserNotFoundException {
        Optional<Student> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID " + id);
    }

    public void delete(Integer id) throws UserNotFoundException  {
        Long count = repo.countStudentById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any users with ID " + id);
        }
        repo.deleteById(id);;

    }

}
