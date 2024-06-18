package vn.codegym.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.StudentDto;
import vn.codegym.entity.Student;
import vn.codegym.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student/v1")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    /* Lấy tài nguyên */
    @GetMapping
    public ResponseEntity<List<Student>> getStudentList() {
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    //Tạo tài nguyên
    @PostMapping
    public ResponseEntity<List<Student>> addStudent(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
