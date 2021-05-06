package org.zing.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private final String propFileName = "project.properties";
    private String webdriverLocation;
    private String browserbinaryLocation;
    private String projectTitle;

    public static ConfigLoader instance = new ConfigLoader();

    ConfigLoader() {
        this.getPropValues();
    }

    public void getPropValues() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)){
            Properties prop = new Properties();

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file " + propFileName + " not found in the classpath");
            }

            webdriverLocation = prop.getProperty("webdriver.location");
            browserbinaryLocation = prop.getProperty("chromebinary.location");
            projectTitle = prop.getProperty("project.title");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWebdriverLocation() {
        return webdriverLocation;
    }

    public String getBrowserbinaryLocation() {
        return browserbinaryLocation;
    }

    public String getProjectTitle() {
        return projectTitle;
    }
}
