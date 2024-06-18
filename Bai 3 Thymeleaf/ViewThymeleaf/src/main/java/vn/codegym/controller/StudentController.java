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

//    @GetMapping("/list")
    @RequestMapping(value = "/list", method = RequestMethod.GET,
    consumes = "application/json",
    produces = "text/html")
    public String showList1(ModelMap modelMap){
        List<Student> studentList = studentService.findAll();
        modelMap.addAttribute("studentList", studentList);
        return "list";
    }

    @GetMapping("/list2")
    public ModelAndView showList2(){
        return new ModelAndView("list",
                "studentList", studentService.findAll());
    }

    @PostMapping
    public String showListPost(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "list";
    }


    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "kq", defaultValue = "") String keyword){
//    public ModelAndView search(@RequestParam String kq){
        return new ModelAndView("list", "studentList",
                studentService.findByName(keyword));
    }

    @GetMapping("/{id:[1-5]}-detail")
    public String showDetail(@PathVariable(value = "id")
                             Integer studentId, Model model){
        System.out.println("Lay thong tin của ban ID: " + studentId);
        model.addAttribute("studentId", studentId);
        return "detail";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        List<String> languageList = new ArrayList<>();
        languageList.add("C#");
        languageList.add("PHP");
        languageList.add("JAVA");
        languageList.add("HTML");

        model.addAttribute("student", new Student());
        model.addAttribute("languageList", languageList);

        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student,
                                RedirectAttributes redirectAttributes){
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Create student: " + student.getName() + " OK");
        return "redirect:/student";
//        return "forward:/student";
    }
}
