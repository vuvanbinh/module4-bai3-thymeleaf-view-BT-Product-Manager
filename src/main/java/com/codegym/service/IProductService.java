package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findByName(String name);
    int findMaxId();
    Product findById(int id);
    List<Product> findAll();
    void save(Product product);
    void update(int id, Product product);
    void delete(int id);
}
