package com.app;

import com.app.model.Currency;
import com.app.repository.CurrenciesRepo;
import com.app.util.XMLService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ServingWebContentApplication {
    private XMLService xmlService = new XMLService();

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    @Bean
    public void run(CurrenciesRepo currenciesRepo) throws Exception {
        List<Currency> currencies = xmlService.parseCourse("http://www.cbr.ru/scripts/XML_daily.asp");

        for (Currency currency: currencies) {
            System.out.println(currency);
        }
    }
}
