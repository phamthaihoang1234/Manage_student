package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class homeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

}
