package com.mturko.bestshop.repository;

import com.mturko.bestshop.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    public List<Product> findAllByPrice(int price);
}
