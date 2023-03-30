package com.example.demo.Controller;

import com.example.demo.DAO.StudentDAO;
import com.example.demo.Entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class studentController {
    private final  StudentDAO _StudentDAO;

    public studentController(StudentDAO studentDAO) {
        _StudentDAO = studentDAO;
    }

    @RequestMapping(value ="/student", method = RequestMethod.GET)
    public String student(Model model){
        List<Student> a = _StudentDAO.getAllStudent();
        model.addAttribute("a", a);

        return  "student";
    }



}
