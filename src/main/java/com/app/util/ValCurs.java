package com.app.util;

import com.app.model.Valute;

import java.util.Date;
import java.util.List;

public class ValCurs {

    private Date date;
    private String name;
    private List<Valute> valuteList;

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
    public List<Valute> getValuteList() {
        return valuteList;
    }
    public void setValuteList(List<Valute> valuteList) {
        this.valuteList = valuteList;
    }
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ValCurs " + date + " " + name + "\n" + valuteList;
    }
}
