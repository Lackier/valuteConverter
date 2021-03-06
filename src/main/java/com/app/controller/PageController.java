package com.app.controller;

import com.app.service.CurrencyService;
import com.app.service.HistoryService;
import com.app.util.HistoryRecord;
import com.app.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {
    @Autowired
    CurrencyService currencyService;
    @Autowired
    HistoryService historyService;
    private int userID = 1;

    @RequestMapping(value = {"/convert"}, method = RequestMethod.GET)
    private String showConvertPage(Model model) {

        List<String> currencyNames = currencyService.findAllCurrencyNamesForToday();
        model.addAttribute("currenciesFrom", currencyNames);
        model.addAttribute("currenciesTo", currencyNames);

        ArrayList<HistoryRecord> records = historyService.getHistoryRecordsById(userID);

        if(!records.isEmpty())
            model.addAttribute("history", records);

        return "convert";
    }

    @RequestMapping(value = {"/convert"}, method = RequestMethod.POST)
    public String convertMoney(Model model,
                               @RequestParam(value = "sum", defaultValue = "0") double sum,
                               @RequestParam(value = "currencyNameFrom") String currencyFrom,
                               @RequestParam(value = "currencyNameTo") String currencyTo) {

        String currencyFromCODE = currencyFrom.split(" ")[0];
        String currencyToCODE = currencyTo.split(" ")[0];

        if (sum > 0) {
            double sumObtained = currencyService.obtainSum(currencyFromCODE, currencyToCODE, sum);
            model.addAttribute("sum", sum);
            model.addAttribute("sumObtained", sumObtained);

            historyService.addRecord(new HistoryRecord(
                    currencyFrom, currencyTo, sum, sumObtained, Util.todayDate()), userID);

            ArrayList<HistoryRecord> records = historyService.getHistoryRecordsById(userID);

            model.addAttribute("history", records);
        }

        model.addAttribute("currenciesFrom", getNewCurrencyNamesList(currencyFrom));
        model.addAttribute("currenciesTo", getNewCurrencyNamesList(currencyTo));

        return "convert";
    }

    @RequestMapping(value = {"/auth"}, method = RequestMethod.GET)
    public String showAuthorisationPage(Model model) {

        return "auth";
    }

    @RequestMapping(value = {"/auth"}, method = RequestMethod.POST)
    public String authorise(Model model,
                            @RequestParam(value = "login") String login,
                            @RequestParam(value = "password") String password){

        boolean correct = true;
        if (!correct)
            return "auth";

        return "redirect:/" + showConvertPage(model);
    }

    private ArrayList<String> getNewCurrencyNamesList(String elementToBeFirst) {
        ArrayList<String> sourceList = currencyService.findAllCurrencyNamesForToday();
        ArrayList<String> currencyNames = new ArrayList<>();

        currencyNames.add(elementToBeFirst);
        sourceList.remove(elementToBeFirst);
        currencyNames.addAll(sourceList);

        return currencyNames;
    }
}
