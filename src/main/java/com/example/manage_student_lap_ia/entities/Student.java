package com.example.manage_student_lap_ia.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "students")
public class Student {



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
            name = "group_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    Set<Group> groups;

    @ManyToMany
    @JoinTable(
            name = "subject_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    Set<Subject> Subjects;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appuser_id", referencedColumnName = "User_Id")
    private AppUser appUserStudent;


}
