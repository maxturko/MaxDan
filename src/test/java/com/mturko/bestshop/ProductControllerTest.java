package com.mturko.bestshop;

import com.mturko.bestshop.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"file:src/main/resources/WEB-INF/application-context.xml", "file:src/main/resources/WEB-INF/web-context.xml"})
public class ProductControllerTest {

    @Autowired
    ProductController productController;

    @Test
    void testSpringContextLoadForJunitTests() {
        assertNotNull(productController);
    }
}
