package com.mturko.bestshop.controller;

import com.mturko.bestshop.model.Product;
import com.mturko.bestshop.dto.ProductDto;
import com.mturko.bestshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam (name = "price") int price) {
        return productService.getAllProductsByPrice(price);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }
}
