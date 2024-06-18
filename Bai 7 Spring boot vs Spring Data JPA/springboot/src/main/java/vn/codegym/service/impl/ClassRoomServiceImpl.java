package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.ClassRoom;
import vn.codegym.repository.IClassRoomRepository;
import vn.codegym.service.IClassRoomService;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements IClassRoomService {

    @Autowired
    private IClassRoomRepository repository;

    @Override
    public List<ClassRoom> findAll() {
        return repository.findAll();
    }
}
