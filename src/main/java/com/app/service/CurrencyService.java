package com.app.service;

import com.app.model.Currency;
import com.app.repository.CurrenciesRepo;
import com.app.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                .forEach(c -> names.add(c.getCharCode() + " " + c.getName()));

        return names;
    }

    public double obtainSum(String currencyFromCODE, String currencyToCODE, double sum) {
        Optional<Currency> currencyFromOpt = currenciesRepo.findByDateAndCharCode(Util.yesterdayDate(), currencyFromCODE);
        Optional<Currency> currencyToOpt = currenciesRepo.findByDateAndCharCode(Util.yesterdayDate(), currencyToCODE);

        if (!currencyFromOpt.isPresent() || !currencyToOpt.isPresent())
            return 0;

        Currency currencyFrom = currencyFromOpt.get();
        Currency currencyTo = currencyToOpt.get();

        return (((currencyFrom.getValue() / currencyFrom.getNominal()) * currencyTo.getNominal())
                / currencyTo.getValue()) * sum;
    }
}
