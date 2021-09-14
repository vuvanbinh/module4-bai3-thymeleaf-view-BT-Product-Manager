package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private static final Map<Integer,Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"product1",1000,"description","producer1"));
        products.put(2,new Product(2,"product2",1000,"description","producer2"));
        products.put(3,new Product(3,"product3",1000,"description","producer3"));
        products.put(4,new Product(4,"product4",1000,"description","producer4"));
        products.put(5,new Product(5,"product5",1000,"description","producer5"));
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        List<Product> products1 = findAll();

        for (Product p : products1
             ) {
            if(p.getName().equals(name)){
                products.add(p);
            }
        }
        return products;
    }

    @Override
    public int findMaxId() {
        List<Product> products = findAll();
        int max=0;
        for (int i = 0; i < products.size(); i++) {
            if (max<products.get(i).getId()){
                max=products.get(i).getId();
            }
        }
        return (max+1);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }
}
