package com.example.feignclient.client.config;

import feign.RequestInterceptor;
import feign.form.ContentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookFeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer mytoken");
        };
    }
}
