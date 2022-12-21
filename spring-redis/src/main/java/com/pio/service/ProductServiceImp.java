package com.pio.service;

import com.pio.model.Product;
import com.pio.repository.RepositoryProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    RepositoryProduct dao;

    @Override
    public Product save(Product product) {
        return dao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) dao.findAll();
    }

    @Override
    public Product findById(long id) {
        System.out.println("calling db");
        return dao.findById(id).get();
    }

    @Override
    public Product update(long id, Product product) {
        Product pro = dao.findById(id).get();
        product.setId(pro.getId());
        return dao.save(product) ;
    }

    @Override
    public String delete(long id) {
        dao.deleteById(id);
        return "Deleted successfull";
    }
}
