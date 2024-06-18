package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Page<Student> findAll(Pageable pageable);

    void save(Student student);

    List<Student> findByName(String keyword);
}
