package vn.codegym.bt1.service;

import vn.codegym.bt1.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void update(int id, Product product);
    void remove(int id);
    Product findByID(int id);
    List<Product> search(String keyword);
}
