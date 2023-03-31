package com.example.manage_student_lap_ia.controller;

import com.example.manage_student_lap_ia.entities.UserNotFoundException;
import com.example.manage_student_lap_ia.entities.Student;
import com.example.manage_student_lap_ia.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class StudentController {

    @Autowired
    StudentServiceImpl sService;


    @GetMapping("/")
    public String showStudentList(Model model) {
        model.addAttribute("listStudents", sService.listAll());

        return "index";
    }

    @GetMapping("/students/new")
    public String showNewForm(Model model) {
        Student s = new Student();
        s.setStatus(1);
        model.addAttribute("student", s);
        model.addAttribute("pageTitle", "Add New Student");
        return "student_form";
    }

    @PostMapping("/students/save")
    public String saveUser(Student student, RedirectAttributes ra) {

        sService.save(student);
        ra.addFlashAttribute("message", "The student has been saved successfully.");
        return "redirect:/";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Student student = sService.get(id);
            model.addAttribute("student", student);
            model.addAttribute("pageTitle", "Edit Student (ID: " + id + ")");

            return "student_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/";
        }
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            Student s = sService.get(id);
            s.setStatus(0);
            sService.save(s);
            ra.addFlashAttribute("message", "The Student ID " + id + " has been deleted.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/";
    }

}
