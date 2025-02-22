package com.example.esb.config;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsbConfig {
    @Bean
    public CamelContext camelContext() {
        return new DefaultCamelContext();
    }
}
