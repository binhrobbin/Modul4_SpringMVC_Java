package vn.codegym.th2.service;

import vn.codegym.th2.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findByID(int id);
    boolean save(Customer customer);
}
