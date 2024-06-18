package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.ClassRoom;
import vn.codegym.model.Course;
import vn.codegym.repository.IClassRoomRepository;
import vn.codegym.repository.ICourseRepository;
import vn.codegym.service.ICourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository repository;

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }
}
