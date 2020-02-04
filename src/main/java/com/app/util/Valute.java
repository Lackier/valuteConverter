package com.app.util;

public class Valute {

    private String ID;
    private String NumCode;
    private String CharCode;
    private int Nominal;
    private String Name;
    private String Value;

    public Valute(String ID, String numCode, String charCode, int nominal, String name, String value) {
        this.ID = ID;
        NumCode = numCode;
        CharCode = charCode;
        Nominal = nominal;
        Name = name;
        Value = value;
    }

    String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getNumCode() {
        return NumCode;
    }
    public void setNumCode(String numCode) {
        NumCode = numCode;
    }
    public String getCharCode() {
        return CharCode;
    }
    public void setCharCode(String charCode) {
        CharCode = charCode;
    }
    public int getNominal() {
        return Nominal;
    }
    public void setNominal(int nominal) {
        Nominal = nominal;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getValue() {
        return Value;
    }
    public void setValue(String value) {
        Value = value;
    }

    @Override
    public String toString() {
        return ID + " " + NumCode + " " + CharCode + " " + Nominal + " " + Name + " " + Value + "\n";
    }
}
