package com.app.service;

import com.app.model.Currency;
import com.app.repository.CurrenciesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    @Autowired
    CurrenciesRepo currenciesRepo;

    public void saveCurrenciesIfNotPresent(Iterable<Currency> currencies) {
        for (Currency currency: currencies) {
            if (!currenciesRepo.findByDateAndName(currency.getDate(), currency.getName()).isPresent())
                currenciesRepo.save(currency);
        }
    }
}
