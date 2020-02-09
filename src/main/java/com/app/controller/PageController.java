package com.app.controller;

import com.app.model.Currency;
import com.app.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    CurrencyService currencyService;

    @RequestMapping(value = {"/convert"}, method = RequestMethod.GET)
    public String show(Model model) {

        List<String> currencyNames = currencyService.findAllCurrencyNamesForToday();
        model.addAttribute("currenciesFrom", currencyNames);
        model.addAttribute("currenciesTo", currencyNames);

        return "convert";
    }

    @RequestMapping(value = {"/convert"}, method = RequestMethod.POST)
    public String convert(Model model,
                          @RequestParam(value = "sum", defaultValue = "0") double sum,
                          @RequestParam(value = "currencyNameFrom") String currencyFrom,
                          @RequestParam(value = "currencyNameTo") String currencyTo) {

        String currencyFromCODE = currencyFrom.split(" ")[0];
        String currencyToCODE = currencyTo.split(" ")[0];

        if (sum > 0) {
            double sumObtained = currencyService.obtainSum(currencyFromCODE, currencyToCODE, sum);
            model.addAttribute("sum", sum);
            model.addAttribute("sumObtained", sumObtained);
        }

        List<String> currencyNames = currencyService.findAllCurrencyNamesForToday();
        model.addAttribute("currenciesFrom", currencyNames);
        model.addAttribute("currenciesTo", currencyNames);

        return "convert";
    }
}
