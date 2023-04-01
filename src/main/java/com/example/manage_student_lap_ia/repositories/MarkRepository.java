package com.example.manage_student_lap_ia.repositories;

import com.example.manage_student_lap_ia.entities.Mark;

import com.example.manage_student_lap_ia.entities.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkRepository extends CrudRepository<Mark, Integer> {


}
