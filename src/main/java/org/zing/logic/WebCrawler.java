package org.zing.logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.zing.config.ChromeDriver;

import java.util.List;


@Component
public class WebCrawler {

    private static final Logger logger = LoggerFactory.getLogger(WebCrawler.class);
    private WebDriver driver;
    private String keyword;

    public WebCrawler() {}


    public void start(List<String> listOfUrls, String keyword) {
        ChromeDriver chromeDriver = new ChromeDriver();
        driver = chromeDriver.driver();
        this.keyword = keyword;

        listOfUrls.forEach(this::scrapePage);

        logger.info("Quiting driver");
        driver.quit();
    }

    public void scrapePage(final String urlString) {
        try {
            logger.info("Navigating to " + urlString);
            driver.get(urlString);
            String xpath = "//*[text() ='" + keyword + "']/..";
            List<WebElement> elemContainingKeyword = driver.findElements(By.xpath(xpath));
            long elementCount = elemContainingKeyword.size();
            logger.info("Number of elements found with keyword '{}': {}", keyword, elementCount);
            elemContainingKeyword.forEach(webElement -> logger.info(webElement.getText()));
        } finally {
            driver.close();
        }
    }
}
