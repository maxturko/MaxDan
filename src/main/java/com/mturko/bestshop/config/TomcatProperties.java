package com.mturko.bestshop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class TomcatProperties {

    private static Properties prop = new Properties();
    private static String hostname;
    private static Integer port;
    static Logger logger = LoggerFactory.getLogger(TomcatProperties.class);
    static {
        try (InputStream input =
                     new BufferedInputStream(
                             new FileInputStream(
                                     System.getProperty("user.dir") + "/classes/tomcat.properties"))) {
            prop.load(input);
            hostname = prop.getProperty("hostname");
            port = Integer.parseInt(prop.getProperty("port"));
            logger.debug(String.format("Setting Tomcat hostname to %s and port to %d", hostname, port));

        } catch (IOException e) {
            logger.error("Failed to set tomcat properties from a property file", e);
        }
    }

    public static String getHostname() {
        return hostname;
    }

    public static Integer getPort() {
        return port;
    }

}
