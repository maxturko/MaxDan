package com.mturko.bestshop;

import com.mturko.bestshop.model.Product;
import com.mturko.bestshop.service.ProductService;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public class ProductServiceTest extends AbstractTest{

    Logger logger = LoggerFactory.getLogger(ProductServiceTest.class);
    private final String productInitialName = "testProduct-" + Instant.now().toString();
    private final int productInitialPrice = 10;
    private final int productUpdatedPrice = 20;
    private Product expectedProduct;
    private Product actualProduct;

    @Autowired
    ProductService productService;

    @BeforeEach
    void setup() {
        Product emptyProduct = productService.getProductByName(productInitialName);
        Assertions.assertNull(emptyProduct);
        expectedProduct = new Product();
        expectedProduct.setName(productInitialName);
        expectedProduct.setPrice(productInitialPrice);
        actualProduct = productService.createProduct(expectedProduct);
    }

    @Test
    void createProduct() {
        Assertions.assertNotNull(actualProduct);
        Assertions.assertEquals(productInitialName, actualProduct.getName());
    }

    @Test
    void readProduct() {
        Product actualProductFoundByName = productService.getProductByName(productInitialName);
        Assertions.assertNotNull(actualProductFoundByName);
        Assertions.assertEquals(productInitialName, actualProductFoundByName.getName());
        List<Product> actualProductFoundByPrice = productService.getAllProductsByPrice(productInitialPrice);
        Assertions.assertTrue(actualProductFoundByPrice.contains(actualProductFoundByName));
    }

    @Test
    void updateProduct() {
        expectedProduct.setPrice(productUpdatedPrice);
        Product updatedProduct = productService.updateProduct(expectedProduct);
        Assertions.assertNotNull(updatedProduct);
        Assertions.assertEquals(productUpdatedPrice, updatedProduct.getPrice());
        expectedProduct = updatedProduct;
    }

    @Test
    void deleteProduct() {
        productService.deleteProduct(expectedProduct);
        Product deletedProduct = productService.getProductByName(productInitialName);
        Assertions.assertNull(deletedProduct);
    }

    @AfterEach
    void teardown() {
        productService.deleteProduct(expectedProduct);
    }
}
