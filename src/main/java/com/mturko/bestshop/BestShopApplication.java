package com.mturko.bestshop;

import com.mturko.bestshop.config.TomcatProperties;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.IOException;

public class BestShopApplication {

	public static void main(String[] args) throws LifecycleException, IOException, ServletException {
		String docBase = BestShopApplication.class.getClassLoader().getResource(".").getPath();
		Tomcat tomcat = new Tomcat();
		tomcat.setHostname(TomcatProperties.getHostname());
		tomcat.setPort(TomcatProperties.getPort());
		tomcat.addWebapp("", docBase);
		tomcat.start();
		tomcat.getServer().await();
	}
}
