package vn.codegym.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accountName;
    private Date dateCreate;
    @OneToOne(mappedBy = "account2")
    private Student student;

    public Account() {
    }

    public Account(int id, String accountName, Date dateCreate, Student student) {
        this.id = id;
        this.accountName = accountName;
        this.dateCreate = dateCreate;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
