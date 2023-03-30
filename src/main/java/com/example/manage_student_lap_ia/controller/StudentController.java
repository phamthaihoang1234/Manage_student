package com.example.manage_student_lap_ia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class StudentController {
    @GetMapping("/")
    public String showUserList() {


        return "index";
    }

}
