package com.example.manage_student_lap_ia.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private float Participation;

    @Column(nullable = false, unique = true, length = 45)
    private float Assignment;

    @Column(nullable = false, unique = true, length = 45)
    private float ProgressTest;

    @Column(nullable = false, unique = true, length = 45)
    private float FinalExam;


    @OneToOne(mappedBy = "mark")
    private Subject subject;
}
