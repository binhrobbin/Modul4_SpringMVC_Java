package vn.codegym.th2.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.th2.model.Customer;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    private static List<Customer> customerList;

    static  {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Nguyen Van A","a@aa","HN"));
        customerList.add(new Customer(2, "Nguyen Van B","a@aa","HN"));
        customerList.add(new Customer(3, "Nguyen Van C","a@aa","HN"));
    }

    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findByID(int id) {
        for (Customer customer:customerList) {
            if (customer.getId() == id)
                return customer;
        }return null;
    }


}
