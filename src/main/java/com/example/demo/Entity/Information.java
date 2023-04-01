package com.example.demo.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name ="information")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "Informationid")
    private int informationId;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "email")
    private String email;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "personid")
    private String personId;

    public Information(int informationId, boolean gender, String email, String phoneNumber, String personId) {
        this.informationId = informationId;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.personId = personId;
    }
}
