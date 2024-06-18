package vn.codegym.repository;

import vn.codegym.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
}
