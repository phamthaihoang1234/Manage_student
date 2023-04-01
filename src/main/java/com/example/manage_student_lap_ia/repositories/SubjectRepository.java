package com.example.manage_student_lap_ia.repositories;

import com.example.manage_student_lap_ia.entities.Student;
import com.example.manage_student_lap_ia.entities.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    public Long countSubjectById (Integer id);
}
