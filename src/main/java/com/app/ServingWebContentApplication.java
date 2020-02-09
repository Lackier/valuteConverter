package com.app;

import com.app.service.CurrencyLoaderService;
import com.app.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServingWebContentApplication {

    private static final Logger log = LoggerFactory.getLogger(ServingWebContentApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CurrencyLoaderService currencyLoader, CurrencyService currencyService) {
        String URL = "http://www.cbr.ru/scripts/XML_daily.asp";

        currencyService.saveCurrenciesIfNotPresent(
                currencyLoader
                        .parseDailyCurrencies(URL)
        );

        return args -> {
            /*
            Iterable<Currency> currencies1 = currenciesRepo.findAll();
            for (Currency currency: currencies1){
                log.info(currency.toString());
            }
            */
        };
    }


}
