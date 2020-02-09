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
                          @RequestParam(value = "sum", required = false, defaultValue = "0") int sum) {

        if (sum != 0) {
            int sumObtained = sum * 10;
            model.addAttribute("sum", sum);
            model.addAttribute("sumObtained", sumObtained);
        }

        return "convert";
    }

    @RequestMapping(value = {"/debug/all"}, method = RequestMethod.GET)
    public String debugAll(Model model) {

        Iterable<Currency> curs = currencyService.findAll();

        StringBuilder stringBuilder = new StringBuilder();
        for (Currency cur : curs)
            stringBuilder.append(cur);

        return stringBuilder.toString();
    }

    @RequestMapping(value = {"/debug/names"}, method = RequestMethod.GET)
    public String debug(Model model) {

        List<String> currencyNames = currencyService.findAllCurrencyNamesForToday();

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : currencyNames)
            stringBuilder.append(s);

        return stringBuilder.toString();
    }
}
