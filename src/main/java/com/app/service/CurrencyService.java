package com.app.service;

import com.app.model.Currency;
import com.app.repository.CurrenciesRepo;
import com.app.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    CurrenciesRepo currenciesRepo;

    public void saveCurrenciesIfNotPresent(Iterable<Currency> currencies) {
        for (Currency currency : currencies) {
            if (!currenciesRepo.findByDateAndName(currency.getDate(), currency.getName()).isPresent())
                currenciesRepo.save(currency);
        }
    }

    public List<String> findAllCurrencyNamesForToday() {
        List<String> names = new ArrayList<>();

        currenciesRepo.findAllByDate(Util.yesterdayDate())
                .forEach(c -> names.add(c.getName()));

        return names;
    }

    public Iterable<Currency> findAll() {
        return currenciesRepo.findAll();
    }
}
