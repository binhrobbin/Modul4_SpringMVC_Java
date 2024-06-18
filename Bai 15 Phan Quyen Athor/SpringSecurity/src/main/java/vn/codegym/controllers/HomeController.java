package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/home", ""})
public class HomeController {
    @GetMapping
    public String showHomepage(){
        return "home";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "MyLogin";
    }
}
