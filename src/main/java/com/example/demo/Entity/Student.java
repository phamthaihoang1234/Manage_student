package com.example.demo.Entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "student")
@AllArgsConstructor
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
    private String fullName  = this.firstName+ " "+this.middleName+" "+this.lastName;

    public Student(int id, String fullName) {
        this.id = id;
        //this.fullName = this.firstName + " " + this.middleName + " "+this.lastName;
        this.fullName= fullName;
    }


}
