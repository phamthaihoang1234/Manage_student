package com.example.manage_student_lap_ia.entities;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "groupsClass")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String NameOfGroup;

    @ManyToMany(mappedBy = "groups")
    Set<Student> listStudents;

    @ManyToMany(mappedBy = "groupsTeachers")
    Set<Teacher> listTeachers;


}
