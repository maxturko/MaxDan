package com.mturko.bestshop;

import com.mturko.bestshop.model.Product;
import com.mturko.bestshop.service.ProductService;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceTest extends AbstractTest{

    Logger logger = LoggerFactory.getLogger(ProductServiceTest.class);
    private static final String productInitialName = "testProduct";
    private static final int productInitialPrice = 10;
    private static final String productUpdatedName = "updatedTestProduct";
    private static final int productUpdatedPrice = 20;
    private static Product testProduct;

    @Autowired
    ProductService productService;

    @Test
    void testSpringContextLoadForJunitTests() {
        assertNotNull(productService);
    }

    @BeforeAll
    static void init(){
        Product product = new Product();
        product.setName(productInitialName);
        product.setPrice(productInitialPrice);
        testProduct = product;
    }

    @Test
    @Order(1)
    void createProduct() {
        productService.createProduct(testProduct);
        List<Product> products = productService.getAllProductsByPrice(10);
        Product product = products.get(0);
        Assertions.assertEquals(productInitialPrice, product.getPrice(), "Asserting price is equal to 10");
        Assertions.assertEquals(1, products.size());
        Assertions.assertEquals(productInitialName, product.getName());
    }

    @Test
    @Order(2)
    void readProduct() {
        List<Product> listOfProducts = productService.getAllProductsByPrice(productInitialPrice);
        Assertions.assertTrue(listOfProducts.contains(testProduct));
    }

    @Test
    @Order(3)
    void updateProduct() {
        Product product = testProduct;
        product.setName(productUpdatedName);
        product.setPrice(productUpdatedPrice);
        testProduct = productService.updateProduct(product);
        Assertions.assertEquals(productUpdatedPrice, testProduct.getPrice());
        Assertions.assertEquals(productUpdatedName, testProduct.getName());
    }

    @Test
    @Order(4)
    void deleteProduct() {
        productService.deleteProduct(testProduct);
        List<Product> products = productService.getAllProductsByPrice(productUpdatedPrice);
        Assertions.assertEquals(0, products.size());

    }
}
