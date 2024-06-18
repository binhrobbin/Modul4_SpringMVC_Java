package vn.codegym.bt1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.bt1.model.Email;
import vn.codegym.bt1.repository.IEmailRepository;

import java.util.Collections;
import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService{
    @Autowired
    private IEmailRepository emailRepository;
    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public void update(Email email) {
        emailRepository.update(email);
    }
}
