package org.zing.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriver implements BrowserDriver {

    @Override
    public WebDriver driver() {
        System.setProperty("webdriver.chrome.driver", ConfigLoader.instance.getWebdriverLocation());
        ChromeOptions options = new ChromeOptions();
        options.setBinary(ConfigLoader.instance.getBrowserbinaryLocation());
        return new org.openqa.selenium.chrome.ChromeDriver(options);
    }
}
