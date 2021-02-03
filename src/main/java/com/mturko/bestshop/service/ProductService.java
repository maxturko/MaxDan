package com.mturko.bestshop.service;

import com.mturko.bestshop.model.Product;
import com.mturko.bestshop.model.dto.ProductDto;
import com.mturko.bestshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCreationDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    public List<Product> getAllProductsByPrice(int price) {
        return productRepository.findAllByPrice(price);
    }
}
