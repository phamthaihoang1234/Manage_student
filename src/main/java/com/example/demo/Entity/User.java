package com.example.demo.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="user")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "userid")
    @NotNull
    private int id;
    @Column(name = "username")
    private final String username;
    @Column(name = "password")
    private final String password;
    //@Column(name = "roleId")
    //private int roleId;
    @ManyToMany
    private List<User> users;

}
