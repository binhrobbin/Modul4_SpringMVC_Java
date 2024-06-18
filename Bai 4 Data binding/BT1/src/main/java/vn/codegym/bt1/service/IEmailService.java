package vn.codegym.bt1.service;

import vn.codegym.bt1.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();
    void update(Email email);
}
