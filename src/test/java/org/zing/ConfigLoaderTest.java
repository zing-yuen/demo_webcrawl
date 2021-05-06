package org.zing;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zing.config.ConfigLoader;

@SpringBootTest
public class ConfigLoaderTest {

    ConfigLoader configLoader = ConfigLoader.instance;

    @Test
    public void loadAndRetrieveProjectConfig() {
        Assert.assertEquals(configLoader.getProjectTitle(), "web_crawler");
    }
}
