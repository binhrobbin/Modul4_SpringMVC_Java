package vn.codegym.bt1.repository;

import vn.codegym.bt1.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAll();
    void update(Email email);
}
