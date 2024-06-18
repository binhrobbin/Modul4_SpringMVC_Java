package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Student;
import vn.codegym.repository.IStudentRepository;
import vn.codegym.service.IStudentService;

import java.util.List;

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
//        return repository.findByName(keyword);
//        return repository.findByNameContaining(keyword);

        /* Tìm theo tên tương đối và ID lớn hơn 2 */
//        return repository.findByNameContainingAndIdGreaterThan(keyword, 2);

        return  repository.searchByName(keyword);



    }
}
