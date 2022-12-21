package com.pio.repository;

import com.pio.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProduct extends CrudRepository<Product, Long> {
}
