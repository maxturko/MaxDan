package com.mturko.bestshop;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"file:src/main/resources/WEB-INF/application-context.xml"})
public abstract class AbstractTest {
}
