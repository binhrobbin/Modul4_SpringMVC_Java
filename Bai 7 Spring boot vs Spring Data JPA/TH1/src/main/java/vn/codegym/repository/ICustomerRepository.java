package vn.codegym.repository;

import org.springframework.data.repository.CrudRepository;
import vn.codegym.model.Customer;
import vn.codegym.model.Province;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
