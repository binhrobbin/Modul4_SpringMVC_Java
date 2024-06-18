package vn.codegym.services;

import vn.codegym.entity.Student;

import java.util.List;


public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    void update(Student student);

    void delete(int id);

    Student findById(int id);

    List<Student> searchByName(String name);
}
