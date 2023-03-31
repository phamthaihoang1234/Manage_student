package com.example.manage_student_lap_ia.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false, length = 45)
    private String FullName;

    @Column(nullable = false, unique = false, length = 45)
    private String Address;

    @Column(nullable = false, unique = true, length = 45)
    private String PhoneNumber;

    @Column(nullable = false, unique = false, length = 45)
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



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


    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Subject> getSubjects() {
        return Subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        Subjects = subjects;
    }

    public AppUser getAppUserStudent() {
        return appUserStudent;
    }

    public void setAppUserStudent(AppUser appUserStudent) {
        this.appUserStudent = appUserStudent;
    }
}
