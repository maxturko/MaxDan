package com.mturko.bestshop.service;

import com.mturko.bestshop.model.Product;
import com.mturko.bestshop.dto.ProductDto;
import com.mturko.bestshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        product.setCreationDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        product.setUpdateDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public List<Product> getAllProductsByPrice(int price) {
        return productRepository.findAllByPrice(price);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

}
