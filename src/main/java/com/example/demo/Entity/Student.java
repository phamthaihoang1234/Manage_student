package com.example.demo.Entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "student")

@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentid")
    @NotNull
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "middlename")
    private String middleName;
    @Column(name = "lastname")
    private String lastName;
    @Transient
    private String fullName;


    @OneToOne
    @JoinColumn(name = "studentid", referencedColumnName = "informationid")
    private Information studentInformation;


    public Student(int id, String fullName) {
        this.id = id;
        this.fullName= fullName;

    }

    public Student(int id, String fullName, Information information) {
        this.id = id;
        this.fullName= fullName;
        this.studentInformation = information;
    }


    public Student(int id, String firstName, String middleName, String lastName, String fullName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fullName = fullName;
    }
}
