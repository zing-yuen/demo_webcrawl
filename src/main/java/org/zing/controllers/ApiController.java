package org.zing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zing.logic.WebCrawler;
import org.zing.models.CrawlRequest;

@Controller
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    WebCrawler webCrawler;

    @PostMapping(value = "/crawl", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity runCrawler(@RequestBody CrawlRequest req) {
        webCrawler.start(req.getUrls(), req.getKeyword());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
