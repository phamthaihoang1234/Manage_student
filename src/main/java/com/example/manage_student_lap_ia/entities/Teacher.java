package com.example.manage_student_lap_ia.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "teaches")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String FullName;

    @Column(nullable = false, unique = true, length = 45)
    private String Address;

    @Column(nullable = false, unique = true, length = 45)
    private String PhoneNumber;

    @ManyToMany
    @JoinTable(
            name = "group_teacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    Set<Group> groupsTeachers;

    @ManyToMany
    @JoinTable(
            name = "subject_teacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    Set<Subject> subjectsTeachers;
}
