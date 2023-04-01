package com.example.manage_student_lap_ia.controller;


import com.example.manage_student_lap_ia.entities.Student;
import com.example.manage_student_lap_ia.entities.Subject;
import com.example.manage_student_lap_ia.entities.UserNotFoundException;
import com.example.manage_student_lap_ia.services.StudentServiceImpl;
import com.example.manage_student_lap_ia.services.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    SubjectServiceImpl subService;

    @Autowired
    StudentServiceImpl stuService;

    List<Subject> subjectList = null;

    @GetMapping("/listSubject/{id}")
    public String listSubjectByStudentid(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
            idUser = id;
            subjectList = subService.listAll(id);

            model.addAttribute("listSubjects", subjectList);

            return "index_subject";

    }

    @GetMapping("/subjects/new")
    public String showNewForm(Model model) {
        System.out.println("idUser la :"+ idUser);
        model.addAttribute("subject", new Subject());
        model.addAttribute("pageTitle", "Add New Subject");
        return "subject_form";
    }

    int idUser = 0;
    @PostMapping("/subject/save")
    public String saveSubject(Subject subject, RedirectAttributes ra,Model model) throws UserNotFoundException {
        System.out.println(subject.getStartDate());
        System.out.println(subjectList.get(0).getStartDate());
        subjectList.add(subject);

        stuService.get(idUser).getSubjects().add(subject);
        subService.save(subject);
        stuService.save(stuService.get(idUser));
        ra.addFlashAttribute("message", "The subject has been saved successfully.");
        subjectList = subService.listAll(idUser);

        model.addAttribute("listSubjects", subjectList);

        return "index_subject";
    }

    /*@GetMapping("/students/edit/{id}")
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
    }*/

    @GetMapping("/subject/delete/{id}")
    public String deleteSubject(@PathVariable("id") Integer id, RedirectAttributes ra, Model model) {
        try {

            stuService.deleteSubject(id,idUser);



            model.addAttribute("message", "The Subject ID " + id + " has been deleted.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        subjectList = subService.listAll(idUser);

        model.addAttribute("listSubjects", subjectList);

        return "index_subject";
    }
}
