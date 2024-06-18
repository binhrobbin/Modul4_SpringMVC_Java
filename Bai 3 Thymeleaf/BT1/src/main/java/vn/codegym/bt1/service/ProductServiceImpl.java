package vn.codegym.bt1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.bt1.model.Product;
import vn.codegym.bt1.repository.IProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public Product findByID(int id) {
        return productRepository.findByID(id);
    }

    @Override
    public List<Product> search(String keyword) {
        return productRepository.search(keyword);
    }


}
