package vn.codegym.service;

import org.springframework.stereotype.Service;
import vn.codegym.model.Student;

import java.util.List;

public class ABC implements StudentService{
    @Override
    public List<Student> findAll() {
        return null;
    }
}
