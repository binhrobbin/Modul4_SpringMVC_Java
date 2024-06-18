package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Student;
import vn.codegym.repository.IStudentRepository;
import vn.codegym.service.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public List<Student> findByName(String keyword) {
        return repository.searchByName(keyword);
    }

    public void abc() {
        Student student = repository.findById(1).orElse(new Student());

        Optional<Student> optionalStudent = repository.findById(1);
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();
        }
    }
}
