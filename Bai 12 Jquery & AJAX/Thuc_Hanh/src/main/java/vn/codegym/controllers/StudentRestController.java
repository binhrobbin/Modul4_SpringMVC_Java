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

@CrossOrigin("*")
@RestController
@RequestMapping("/api/student/v1")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudentList(){
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable int id){
        Student student = studentService.findById(id);
        StudentDto studentDto = new StudentDto();
        if (student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(student,studentDto);
        return new ResponseEntity<>(studentDto,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto){
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> addStudent(@PathVariable int id, @RequestBody StudentDto studentDto){
        Student student = studentService.findById(id);
        if (student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> addStudent(@PathVariable int id){
        Student student = studentService.findById(id);
        if (student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
