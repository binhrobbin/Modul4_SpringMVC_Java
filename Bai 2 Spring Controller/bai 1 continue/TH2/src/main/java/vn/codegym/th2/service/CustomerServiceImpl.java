package vn.codegym.th2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.th2.model.Customer;
import vn.codegym.th2.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findByID(int id) {
        return repository.findByID(id);
    }

    @Override
    public boolean save(Customer customer) {
        return repository.save(customer);
    }
}
