package com.example.manage_student_lap_ia.repositories;

import com.example.manage_student_lap_ia.entities.Student;
import com.example.manage_student_lap_ia.entities.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    public Long countSubjectById (Integer id);

    @Query("SELECT s FROM Student st JOIN st.Subjects s WHERE st.id = :studentId")
    List<Subject> findSubjectsByStudentId(@Param("studentId") Integer studentId);


}
