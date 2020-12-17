package com.mturko.bestshop.controller;

import com.mturko.bestshop.model.Product;
import com.mturko.bestshop.model.dto.ProductDto;
import com.mturko.bestshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam (name = "price") int price) {
        return productService.getAllProductsByPrice(price);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Map<String, Object> payload) {
        ProductDto productDto = new ProductDto();
        productDto.setName(payload.get("name").toString());
        productDto.setPrice(Integer.parseInt(payload.get("price").toString()));
        return productService.addProduct(productDto);
    }
}
