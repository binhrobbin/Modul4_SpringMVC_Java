package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
}