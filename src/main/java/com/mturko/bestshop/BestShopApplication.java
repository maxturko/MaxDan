package com.mturko.bestshop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BestShopApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"spring-config.xml");

	}

}
