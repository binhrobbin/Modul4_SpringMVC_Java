package vn.codegym.bt1.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.bt1.model.Email;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepositoryImpl implements IEmailRepository{
    private static List<Email> emailList;

    static {
        emailList = new ArrayList<>();
        emailList.add(new Email("English", 25, "on", "Thor<br>King,Asgard"));

    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public void update(Email email) {

        emailList.set(0,email);
    }

}
