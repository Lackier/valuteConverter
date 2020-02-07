package com.app;

import com.app.model.Currency;
import com.app.repository.CurrenciesRepo;
import com.app.service.CurrencyLoaderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ServingWebContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    @Bean
    public void run(CurrenciesRepo currenciesRepo, CurrencyLoaderService currencyService) throws Exception {
        List<Currency> currencies = currencyService.parseDailyCurrencies("http://www.cbr.ru/scripts/XML_daily.asp");

        for (Currency currency: currencies) {
            System.out.println(currency);
        }
    }
}
