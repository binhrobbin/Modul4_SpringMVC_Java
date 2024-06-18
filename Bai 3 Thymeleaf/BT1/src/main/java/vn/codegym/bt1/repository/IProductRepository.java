package vn.codegym.bt1.repository;

import vn.codegym.bt1.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IProductRepository {

    List<Product> findAll();
    void save(Product product);
    void update(int id, Product product);
    void remove(int id);
    Product findByID(int id);

    List<Product> search(String keyword);
}
