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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getParticipation() {
        return Participation;
    }

    public void setParticipation(float participation) {
        Participation = participation;
    }

    public float getAssignment() {
        return Assignment;
    }

    public void setAssignment(float assignment) {
        Assignment = assignment;
    }

    public float getProgressTest() {
        return ProgressTest;
    }

    public void setProgressTest(float progressTest) {
        ProgressTest = progressTest;
    }

    public float getFinalExam() {
        return FinalExam;
    }

    public void setFinalExam(float finalExam) {
        FinalExam = finalExam;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
