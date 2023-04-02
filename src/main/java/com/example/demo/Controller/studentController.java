package com.example.demo.Controller;

import com.example.demo.DAO.InformationDAO;
import com.example.demo.DAO.StudentDAO;
import com.example.demo.DAO.UserDAO;
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
    private final UserDAO _UserDAO;


    private final InformationDAO _InformationDAO;

    public studentController(StudentDAO studentDAO, UserDAO userDAO, InformationDAO informationDAO) {
        _StudentDAO = studentDAO;
        _UserDAO = userDAO;
        _InformationDAO = informationDAO;
    }

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

    @RequestMapping(value = "/studentdetail",params ={"sid"},method = RequestMethod.GET)
    public String studentDetail(Model model, @RequestParam(name = "sid") int sid){
        Student s = _StudentDAO.getStudentById(sid);
        s.setFullName(s.getFirstName()+" "+s.getMiddleName()+" "+s.getLastName());

        Information i = _InformationDAO.getInformationById(sid);
        model.addAttribute("i", i);
        model.addAttribute("s", s);
        return "studentdetail";
    }





}
