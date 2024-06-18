package vn.codegym.bt1.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.bt1.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
    private static Map<Integer, Product> mapList;
    static {
        mapList = new HashMap<>();
        mapList.put(1,new Product(1,"S22 ultra",1500,"black","samsung"));
        mapList.put(2,new Product(2,"Note20 ultra",1200,"copper","samsung"));
        mapList.put(3,new Product(3,"Iphone 15 promax",1600,"gray","apple"));
        mapList.put(4,new Product(4,"Iphone 12",860,"green","apple"));
        mapList.put(5,new Product(5,"Mi 10",580,"white","xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>(mapList.values());
        return list;
    }

    @Override
    public void save(Product product) {
        mapList.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        mapList.put(id,product);
    }

    @Override
    public void remove(int id) {
        mapList.remove(id);
    }

    @Override
    public Product findByID(int id) {
        return mapList.get(id);
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> list = new ArrayList<>(mapList.values());
        List<Product> list2 = new ArrayList<>();
        for (Product product: list){
            if (product.getName().contains(keyword)) list2.add(product);
        }
        return list2;
    }


}
