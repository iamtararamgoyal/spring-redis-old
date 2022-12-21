package com.pio.service;

import com.pio.model.Product;

import java.util.List;

public interface ProductService {
    public Product save(Product product);

    public List<Product> findAll();

    public Product findById(long id);

    public Product update(long id, Product product);

    public String delete(long id);

}
