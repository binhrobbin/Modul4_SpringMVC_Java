package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.Student;
import vn.codegym.service.IStudentService;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

//    @Qualifier("studentServiceImpl")
    @Autowired
    private  IStudentService studentService ;


    @GetMapping
    public String showList(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "list";
    }

}
