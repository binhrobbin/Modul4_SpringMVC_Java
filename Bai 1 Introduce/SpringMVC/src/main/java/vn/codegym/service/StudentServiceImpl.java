package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import vn.codegym.model.Student;
import vn.codegym.repository.StudentRepository;
import vn.codegym.repository.StudentRepositoryImpl;

import java.util.List;

/**
 * (C) Copyright 2023 CodeGym Da Nang. All Rights Reserved.
 *
 * @author caube
 * @version 1.0
 * @see <a href="https://danang.codegym.vn/">CodeGym Da Nang</a>
 * @since 10/12/2023
 */

@Service
//@Primary
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }
}
