package com.example.feignclient.client;

import com.example.feignclient.client.config.BookFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "book", url = "http://${book.host}:${book.port}/", configuration = BookFeignConfiguration.class)
public interface BookClient {
    @RequestMapping(method = RequestMethod.GET, value = "/book")
    List<String> getBooks();
}
