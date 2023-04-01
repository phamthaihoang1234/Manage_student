package com.example.manage_student_lap_ia.services;


import com.example.manage_student_lap_ia.entities.Student;
import com.example.manage_student_lap_ia.entities.Subject;
import com.example.manage_student_lap_ia.entities.UserNotFoundException;
import com.example.manage_student_lap_ia.repositories.StudentRepository;
import com.example.manage_student_lap_ia.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl {
    @Autowired
    private SubjectRepository repo;




    public List<Subject> listAll(Integer Subid) {
        return (List<Subject>)repo.findSubjectsByStudentId(Subid);
    }

    public void save(Subject sub) {

        repo.save(sub);
    }

    public Subject get(Integer id) throws UserNotFoundException {
        Optional<Subject> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID " + id);
    }

    public void delete(Integer id) throws UserNotFoundException  {
        Long count = repo.countSubjectById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any users with ID " + id);
        }
        repo.deleteById(id);;

    }
}
