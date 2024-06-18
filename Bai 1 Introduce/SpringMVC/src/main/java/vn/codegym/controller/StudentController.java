package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    private String showList(Model model, ModelMap modelMap){
        model.addAttribute("studentList", service.findAll());
//        System.out.println("Da vao get 1");
//        model.addAttribute("studentName", "Hung");
//        modelMap.addAttribute("studentAge", 22);
        return "list";
    }

    @GetMapping("/list")
    private ModelAndView showList2(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("studentName", "Hung");
        modelAndView.addObject("studentAge", 22);

        return modelAndView;
//        return new ModelAndView("list", "studentName", "Hung");
    }

}
