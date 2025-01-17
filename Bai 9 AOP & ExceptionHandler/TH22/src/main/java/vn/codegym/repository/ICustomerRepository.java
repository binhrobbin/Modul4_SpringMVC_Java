package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Customer;


public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
