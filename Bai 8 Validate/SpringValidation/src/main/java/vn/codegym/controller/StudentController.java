package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
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
import java.util.List;

@Controller
@RequestMapping({"/student", "/home"})
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassRoomService classRoomService;

    @Autowired
    private ICourseService courseService;


    @GetMapping(value = "/list")
    public ModelAndView showStudentList(@PageableDefault(value = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
//        Sort emailSort = Sort.by("email");
//        Sort firstName = Sort.by("firstName");
//        Sort group  = emailSort.and(firstName);
//        pageable.getSortOr(group);

        Sort sort = Sort.by(
                Sort.Order.asc("name"),
                Sort.Order.desc("id")
        );
//        pageable.getSortOr(sort);


        Pageable paging = PageRequest.of(0, 5, Sort.by("firstName").ascending());


        return new ModelAndView("student",
                "studentList",
                studentService.findAll(pageable));
    }

    @PostMapping("/list")
    public ModelAndView showStudentList1() {
        return new ModelAndView("student",
                "studentList", studentService.findAll());
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {

        model.addAttribute("classRoomList", classRoomService.findAll());
        model.addAttribute("courseList", courseService.findAll());

        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student,
                                RedirectAttributes redirectAttributes
    ) {
        student.getAccount().setDateCreate(new Date(System.currentTimeMillis()));
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message",
                "Create student: " + student.getName() + " OK!");
        return "redirect:/student/list";

    }

    @GetMapping("/search")
    public String search(@RequestParam("kq") String keyword,
                         Model model) {
        List<Student> studentList = studentService.findByName(keyword);
        model.addAttribute("studentList", studentList);
        return "student";
    }
}