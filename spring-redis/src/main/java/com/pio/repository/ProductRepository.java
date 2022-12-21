package com.pio.repository;

import com.pio.comman.Constant;
import com.pio.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class ProductRepository {

    @Autowired
    private RedisTemplate template;


    public Product save(Product product) {
        template.opsForHash().put(Constant.HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return template.opsForHash().values(Constant.HASH_KEY);
    }

    public Product findProductById(int id) {
        log.info("Calling... DB");
        return (Product) template.opsForHash().get(Constant.HASH_KEY, id);
    }


    public String deleteProduct(int id) {
        template.opsForHash().delete(Constant.HASH_KEY, id);
        return "product removed !!";
    }
}
