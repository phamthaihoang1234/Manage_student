package com.example.manage_student_lap_ia.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = true,  length = 45)
    private float Participation;

    @Column(nullable = true, length = 45)
    private float Assignment;

    @Column(nullable = true, length = 45)
    private float ProgressTest;

    @Column(nullable = true,  length = 45)
    private float FinalExam;



    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
}
