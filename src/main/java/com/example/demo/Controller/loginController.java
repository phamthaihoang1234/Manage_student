package com.example.demo.Controller;


import com.example.demo.DAO.UserDAO;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class loginController {
    private final UserDAO _userDAO;

    @Autowired
    public loginController(UserDAO userDAO) {
        _userDAO = userDAO;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login1(@RequestParam(name = "fname") String fname, @RequestParam(name = "lname") String lname) {
        User user = _userDAO.getUserByUsername(fname);

        return "redirect:/home/";
    }
}


