package com.mturko.bestshop;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class BestShopApplication {

	public static void main(String[] args) throws LifecycleException, ServletException {
		Tomcat tomcat = new Tomcat();

		//Set Port #
		tomcat.setBaseDir("D:\\Projects\\bestShop\\target");
		tomcat.setPort(8080);
		tomcat.setHostname("localhost");

		String contextPath = "/";
		String warFilePath = "D:\\Projects\\bestShop\\target\\bestShop-0.0.1-SNAPSHOT.war";

		tomcat.getHost().setAppBase(".");

		tomcat.addWebapp(contextPath, warFilePath);

		tomcat.start();
		tomcat.getServer().await();

	}

}
