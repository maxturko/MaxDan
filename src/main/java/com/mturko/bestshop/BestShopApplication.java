package com.mturko.bestshop;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

public class BestShopApplication {

	public static void main(String[] args) throws LifecycleException, ServletException {
		Tomcat tomcat = new Tomcat();

		//Set Port #
		tomcat.setBaseDir("D:\\Projects\\bestShop\\target");
		tomcat.setPort(8080);
		tomcat.setHostname("localhost");

		String contextPath = "/";
		String warFilePath = ".\\bestShop-0.0.1-SNAPSHOT.war";

		tomcat.getHost().setAppBase(".");

		tomcat.addWebapp(contextPath, warFilePath);

		tomcat.start();
		tomcat.getServer().await();

	}

}
