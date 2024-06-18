package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.model.Customer;
import vn.codegym.model.Province;

import java.util.Optional;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(Pageable pageable, String name);

    Iterable<Customer> findAll();

    void save(Customer customer);

    void deleteById(Long id);

    Optional<Customer> findById(Long id);
}
