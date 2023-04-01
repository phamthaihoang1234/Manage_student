package com.example.demo.Controller;

import com.example.demo.DAO.InformationDAO;
import com.example.demo.DAO.StudentDAO;
import com.example.demo.Entity.Information;
import com.example.demo.Entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class studentController {
    private final  StudentDAO _StudentDAO;

    public studentController(StudentDAO studentDAO, InformationDAO informationDAO) {
        _StudentDAO = studentDAO;
        _InformationDAO = informationDAO;
    }

    private final InformationDAO _InformationDAO;

    @RequestMapping(value ="/student", method = RequestMethod.GET)
    public String student(Model model){
        List<Student> a = _StudentDAO.getAllStudent();

        for (Student b: a
             ) {
            b.setFullName(b.getFirstName() +" "+b.getMiddleName()+ " "+b.getLastName());

        }
        model.addAttribute("a", a);

        return  "student";
    }

    @RequestMapping(value = "/student-detail?sid={id}", method = RequestMethod.GET)
    public String studentDetail(Model model, @RequestParam(name ="id") Integer id){
        Student s = _StudentDAO.getStudentById(id);
        Information i = _In
        return ;
    }





}
