package com.mturko.bestshop;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class BestShopApplication {

	public static void main(String[] args) throws LifecycleException, IOException, ServletException {
		Path temporaryDirPath = Files.createTempDirectory(UUID.randomUUID().toString());
		Tomcat tomcat = new Tomcat();
		//Set Port #
		tomcat.setBaseDir(temporaryDirPath.toAbsolutePath().toString());
		tomcat.setPort(8080);
		tomcat.setHostname("localhost");
		String docBase = System.getProperty("user.dir") + "/classes";
		tomcat.addWebapp("", docBase);
		tomcat.start();
		tomcat.getServer().await();
	}

}
