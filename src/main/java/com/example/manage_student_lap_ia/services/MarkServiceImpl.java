package com.example.manage_student_lap_ia.services;

import com.example.manage_student_lap_ia.entities.Mark;
import com.example.manage_student_lap_ia.entities.Subject;
import com.example.manage_student_lap_ia.entities.UserNotFoundException;
import com.example.manage_student_lap_ia.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarkServiceImpl {

    @Autowired
    MarkRepository markRepo;
    public void save(Mark m) {

        markRepo.save(m);
    }

    public Mark getMarkById(Integer id) throws UserNotFoundException {
        Optional<Mark> result = markRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID " + id);
    }
}
