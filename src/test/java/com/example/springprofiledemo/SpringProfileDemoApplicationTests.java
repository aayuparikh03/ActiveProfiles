package com.example.springprofiledemo;

import org.example.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = AppConfig.class)
@ActiveProfiles("dev") // Specify the "dev" profile for this test class
class DevProfileTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void testBeanForDevProfile() {
        assertTrue(context.containsBean("devDataSource"));
        assertFalse(context.containsBean("prodDataSource"));
    }
}

@SpringJUnitConfig(classes = AppConfig.class)
@ActiveProfiles("prod") // Specify the "prod" profile for this test class
class ProdProfileTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void testBeanForProdProfile() {
        assertTrue(context.containsBean("prodDataSource"));
        assertFalse(context.containsBean("devDataSource"));
    }
}
