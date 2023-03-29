package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserCreationDTO  implements Serializable {
    private String name;
    private String password;
    private List<Integer> roleId;

}
