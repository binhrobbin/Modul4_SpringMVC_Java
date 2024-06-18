package vn.codegym.service;

import vn.codegym.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();

    void save(User user);

    Optional<User> findById(int id);

    void remove(int id);
}
