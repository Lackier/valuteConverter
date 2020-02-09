package com.app.controller;

import com.app.model.Currency;
import com.app.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class PageController {
    @Autowired
    CurrencyService currencyService;

    @RequestMapping(value = {"/convert"}, method = RequestMethod.GET)
    public String show(Model model) {

        List<String> currencyNames = currencyService.findAllCurrencyNamesForToday(new Date());

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

    @RequestMapping(value = {"/debug"}, method = RequestMethod.GET)
    public String debugMethod() {

        StringBuilder stringBuilder = new StringBuilder();
        Iterable<Currency> curs = currencyService.findAll();

        for (Currency cur : curs)
            stringBuilder.append(cur.toString());

        return stringBuilder.toString();
    }

    @RequestMapping(value = {"/debug/names"}, method = RequestMethod.GET)
    public String debugNamesMethod() {

        StringBuilder stringBuilder = new StringBuilder();
        Iterable<String> names = currencyService.findAllCurrencyNamesForToday(new Date());

        for (String name : names)
            stringBuilder.append(name);

        return stringBuilder.toString();
    }
}
