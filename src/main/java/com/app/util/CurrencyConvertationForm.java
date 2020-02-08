package com.app.util;

public class CurrencyConvertationForm {
    private String currencyFromName;
    private String currencyToName;
    private int sum;
    private int sumObtained;

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

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSumObtained() {
        return sumObtained;
    }

    public void setSumObtained(int sumObtained) {
        this.sumObtained = sumObtained;
    }
}
