package org.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
    @Bean
    public String commonBean() {
        return "This is a common bean for all profiles";
    }
    @Bean
    @Profile("dev")
    public String devDataSource() {
        return "Development DataSource: Connected to dev database";
    }
    @Bean
    @Profile("prod")
    public String prodDataSource() {
        return "Production DataSource: Connected to production database";
    }
}