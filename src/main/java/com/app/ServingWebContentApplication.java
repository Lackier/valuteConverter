package com.app;

import com.app.util.ValCurs;
import com.app.util.XMLService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServingWebContentApplication {
    private XMLService xmlService = new XMLService();

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    @Bean
    public void run() throws Exception {
        ValCurs valutes = xmlService.parseCourse("http://www.cbr.ru/scripts/XML_daily.asp");
        System.out.println(valutes);
    }
}
