package com.app;

import com.app.model.Currency;
import com.app.repository.CurrenciesRepo;
import com.app.service.CurrencyLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ServingWebContentApplication implements CommandLineRunner {

    @Autowired
    private CurrencyLoaderService currencyService;

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Currency> currencies = currencyService.parseDailyCurrencies("http://www.cbr.ru/scripts/XML_daily.asp");

        for (Currency currency: currencies) {
            System.out.println(currency);
        }
    }
}
