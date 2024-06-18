package vn.codegym.service;

import vn.codegym.model.Customer;
import vn.codegym.model.Province;

public interface ICustomerService extends IGenerateService<Customer>{
    Iterable<Customer> findAllByProvince(Province province);
}
