package org.zing;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.Test;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zing.logic.WebCrawler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WebCrawlerTest {

    @Autowired
    WebCrawler webCrawler;

    @Test
    public void findKeywordInPage() {
        Logger logger = (Logger) LoggerFactory.getLogger(WebCrawler.class);

        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();

        logger.addAppender(listAppender);

        List<String> urls = Collections.singletonList("https://en.wikipedia.org/wiki/Main_Page");
        webCrawler.start(urls, "Wikipedia");

        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals("Welcome to Wikipedia",logsList.get(2).getMessage());

    }
}
