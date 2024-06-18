package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.entity.Student;

import java.util.List;

public interface  StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameContaining(String name);
}
