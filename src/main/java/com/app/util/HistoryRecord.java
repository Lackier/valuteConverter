package com.app.util;

import java.time.LocalDate;

public class HistoryRecord {

    private String currencyFromName;
    private String currencyToName;
    private double sum;
    private double sumObtained;
    private LocalDate date;

    public HistoryRecord(String currencyFromName, String currencyToName, double sum, double sumObtained, LocalDate date) {
        this.currencyFromName = currencyFromName;
        this.currencyToName = currencyToName;
        this.sum = sum;
        this.sumObtained = sumObtained;
        this.date = date;
    }

    protected HistoryRecord() {
    }

    public String getCurrencyFromName() {
        return currencyFromName;
    }

    public void setCurrencyFromName(String currencyFromName) {
        this.currencyFromName = currencyFromName;
    }

    public String getCurrencyToName() {
        return currencyToName;
    }

    public void setCurrencyToName(String currencyToName) {
        this.currencyToName = currencyToName;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getSumObtained() {
        return sumObtained;
    }

    public void setSumObtained(double sumObtained) {
        this.sumObtained = sumObtained;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
