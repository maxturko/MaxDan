package com.mturko.bestshop;

import com.mturko.bestshop.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductControllerTest extends AbstractTest{

    @Autowired
    ProductController productController;

    @Test
    void testSpringContextLoadForJunitTests() {
        assertNotNull(productController);
    }
}
