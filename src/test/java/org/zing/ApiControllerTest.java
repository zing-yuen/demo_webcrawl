package org.zing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.zing.models.CrawlRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void okStatus() throws Exception {
        CrawlRequest mockReq = new CrawlRequest();
        List<String> urls = Collections.singletonList("https://en.wikipedia.org/wiki/Main_Page");
        mockReq.setUrls(urls);
        mockReq.setKeyword("Main page");
        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc.perform(post("/api/v1/crawl")
                .contentType("application/json")
                .content(mapper.writeValueAsString(mockReq)))
                .andExpect(status().isOk());

    }
}
