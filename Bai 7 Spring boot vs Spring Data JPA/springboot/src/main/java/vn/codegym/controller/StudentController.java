package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Student;
import vn.codegym.service.IClassRoomService;
import vn.codegym.service.ICourseService;
import vn.codegym.service.IStudentService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/student"})
public class StudentController {

//    @Qualifier("studentServiceImpl")
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassRoomService classRoomService;
    @Autowired
    private ICourseService courseService;


    @RequestMapping(value = "/list",
                    method = RequestMethod.GET)
//                    consumes = "text/html",
//                    produces = "text/html")
    public ModelAndView showStudentList(@PageableDefault(value = 5) Pageable pageable){
//        Sort id = Sort.by("id");
//        Sort name = Sort.by("name");
//        Sort group  = id.and(name);
//        pageable.getSortOr(name);
            return new ModelAndView("student", "studentList", studentService.findAll(pageable));
    }

    @PostMapping("/list")
    public ModelAndView showStudentList1(){
        return new ModelAndView("student",
                "studentList", studentService.findAll());
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("classRoomList",classRoomService.findAll());
        model.addAttribute("courseList",courseService.findAll());
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student,
                                RedirectAttributes redirectAttributes){
//        int id = Integer.parseInt(request.getParameter("studentId"));
//        String name = request.getParameter("studentName");
//        System.out.println(id + "---------" + name);
        student.getAccount2().setDateCreate(new Date(System.currentTimeMillis()));
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message",
                "Create student: " + student.getName() + " OK!");
//        return "forward:/student/list";
        return "redirect:/student/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("kq") String keyword, Model model){
        model.addAttribute("studentList",
                studentService.findByName(keyword));
        return "student";
    }
}
