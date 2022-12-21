package com.pio.controller;

import com.pio.model.Product;
import com.pio.repository.ProductRepository;
import com.pio.repository.RepositoryProduct;
import com.pio.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@EnableCaching
@Slf4j
public class RedisController {

    /*  @Autowired
      ProductRepository dao;*/
    @Autowired
    ProductService service;


    @PostMapping
    public Product save(@RequestBody Product product) {

        return service.save(product);
    }

    @GetMapping

    public List<Product> getAllProducts() {

        return (List<Product>) service.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "Product")
    public Product findProduct(@PathVariable long id) {
        System.out.println("calling controller");
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable long id) {


        service.delete(id);
        return "deleted";
    }

}
