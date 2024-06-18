package vn.codegym.th2.repository;

import vn.codegym.th2.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findByID(int id);
    boolean save(Customer customer);
}
