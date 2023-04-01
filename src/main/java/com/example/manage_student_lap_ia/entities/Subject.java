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

    @Column(nullable = false, unique = false, length = 45)
    private String Semester;

    @Column(nullable = false, unique = false, length = 45)
    private LocalDate StartDate;

    @Column(nullable = false, unique = false, length = 45)
    private LocalDate EndDate;

    @Column(nullable = false, unique = false, length = 45)
    private float AveMark;



    @Column(nullable = false, unique = false, length = 45)
    private Boolean Status = true;

    @ManyToMany(mappedBy = "Subjects")
    Set<Student> listStudents;

    @ManyToMany(mappedBy = "subjectsTeachers")
    Set<Teacher> listTeachers;

    @OneToMany(mappedBy="subject")
    private Set<Mark> marks;

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        SubjectCode = subjectCode;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    public float getAveMark() {
        return AveMark;
    }

    public void setAveMark(float aveMark) {
        AveMark = aveMark;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public Set<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(Set<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public Set<Teacher> getListTeachers() {
        return listTeachers;
    }

    public void setListTeachers(Set<Teacher> listTeachers) {
        this.listTeachers = listTeachers;
    }





}
