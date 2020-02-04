package com.app.util;

import java.util.List;

public class ValCurs {

    private String Date;
    private String name;
    private List<Valute> valutes;

    public ValCurs(String date, String name) {
        Date = date;
        this.name = name;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Valute> getValutes() {
        return valutes;
    }
    public void setValutes(List<Valute> valutes) {
        this.valutes = valutes;
    }
    public String getDate() {
        return Date;
    }

    @Override
    public String toString() {
        return "ValCurs " + Date + " " + name + "\n" + valutes;
    }
}
