package com.example.manage_student_lap_ia.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String SubjectCode;

    @Column(nullable = false, unique = true, length = 45)
    private String Semester;

    @Column(nullable = false, unique = true, length = 45)
    private LocalDate StartDate;

    @Column(nullable = false, unique = true, length = 45)
    private LocalDate EndDate;

    @Column(nullable = false, unique = true, length = 45)
    private float AveMark;



    @Column(nullable = false, unique = true, length = 45)
    private Boolean Status;

    @ManyToMany(mappedBy = "Subjects")
    Set<Student> listStudents;

    @ManyToMany(mappedBy = "subjectsTeachers")
    Set<Teacher> listTeachers;




    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mark_id", referencedColumnName = "id")
    private Mark mark;

}
