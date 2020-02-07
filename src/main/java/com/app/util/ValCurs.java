package com.app.util;

import com.app.model.Currency;

import java.util.Date;
import java.util.List;

public class ValCurs {

    private Date date;
    private String name;
    private List<Currency> currencyList;

    public ValCurs(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    public void setDate(Date Date) {
        this.date = Date;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Currency> getCurrencyList() {
        return currencyList;
    }
    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ValCurs " + date + " " + name + "\n" + currencyList;
    }
}
