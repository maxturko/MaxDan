package com.mturko.bestshop;

import com.mturko.bestshop.config.TomcatProperties;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.UUID;

public class BestShopApplication {

	public static void main(String[] args) throws LifecycleException, IOException, ServletException {
		String docBase = System.getProperty("user.dir") + "/classes";
		Path temporaryDirPath = Files.createTempDirectory(UUID.randomUUID().toString());
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir(temporaryDirPath.toAbsolutePath().toString());
		tomcat.setHostname(TomcatProperties.getHostname());
		tomcat.setPort(TomcatProperties.getPort());
		tomcat.addWebapp("", docBase);
		tomcat.start();
		tomcat.getServer().await();
	}
}
