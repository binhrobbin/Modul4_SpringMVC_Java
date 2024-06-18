package vn.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> productMap = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product,Integer> products) {
        this.productMap = products;
    }

    public Map<Product,Integer> getProducts() {
        return productMap;
    }

    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product,Integer> entry : productMap.entrySet()){
            if (entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            productMap.put(product,1);
        }else {
            Map.Entry<Product,Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue()+1;
            productMap.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public void subtractProduct(Product product){
        if (checkItemInCart(product)) {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            if (itemEntry.getValue() > 1) {
                Integer newQuantity = itemEntry.getValue() - 1;
                productMap.replace(itemEntry.getKey(), newQuantity);
            }else productMap.remove(itemEntry.getKey());
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product,Integer> entry: productMap.entrySet()){
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return productMap.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
