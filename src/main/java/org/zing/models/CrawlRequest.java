package org.zing.models;

import java.util.List;

public class CrawlRequest {
    List<String> urls;
    String keyword;

    public CrawlRequest() {
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
