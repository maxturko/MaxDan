package com.mturko.bestshop.repository;

import com.mturko.bestshop.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

     public List<Product> findAllByPrice(int price);

     public Product findByName(String name);
}
