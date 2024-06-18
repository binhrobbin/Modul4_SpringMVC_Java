package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.User;
import vn.codegym.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @GetMapping()
    public ModelAndView showForm(){
    ModelAndView modelAndView = new ModelAndView("index","user",new User());
    return modelAndView;
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
    if (bindingResult.hasFieldErrors()){
        return "index";
    }
    else {
        service.save(user);
        model.addAttribute("message","Bạn đã nhập thành công");
        return "result";
    }
    }
}
