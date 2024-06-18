package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Student;
import vn.codegym.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Qualifier("studentServiceImpl")
    @Autowired
    private  IStudentService studentService;


    @GetMapping
    public String showList(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "list";
    }
//
//    @PostMapping
//    public String showList2(Model model){
//        List<Student> studentList = studentService.findAll();
//        model.addAttribute("studentList", studentList);
//        return "list";
//    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        List<String> languageList = new ArrayList<>();
        languageList.add("C#");
        languageList.add("PHP");
        languageList.add("JAVA");
        languageList.add("ReactJS");

        model.addAttribute("languageList", languageList);
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student,RedirectAttributes redirectAttributes,Model model){
        model.addAttribute("message2", " OK");
        redirectAttributes.addFlashAttribute("message", "Create student: "+ student.getName() + " OK");
//        System.out.println(student);
        studentService.save(student);
//        return "forward:/student";
        return "redirect:/student";
    }

}
