package vn.codegym.services;

import vn.codegym.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    void save(Student student);
    void remove(int id);
    Student findById(int id);
    List<Student> searchByName(String name);
}
