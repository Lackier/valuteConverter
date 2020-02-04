package com.app.util;

import javax.xml.bind.annotation.*;

@XmlType(name = "Valute",
        propOrder = {
        "ID", "numCode", "charCode", "nominal", "name", "value"
})

public class Valute {

    private String ID;

    private String NumCode;

    private String CharCode;

    private int Nominal;

    private String Name;

    private String Value;

    public Valute(){
        ;
    }

    public Valute(String ID, String numCode, String charCode, int nominal, String name, String value) {
        this.ID = ID;
        NumCode = numCode;
        CharCode = charCode;
        Nominal = nominal;
        Name = name;
        Value = value;
    }

    @XmlElement (name = "ID")
    String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    @XmlElement (name = "numCode")
    public String getNumCode() {
        return NumCode;
    }

    public void setNumCode(String numCode) {
        NumCode = numCode;
    }
    @XmlElement (name = "charCode")
    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String charCode) {
        CharCode = charCode;
    }
    @XmlElement (name = "nominal")
    public int getNominal() {
        return Nominal;
    }

    public void setNominal(int nominal) {
        Nominal = nominal;
    }
    @XmlElement (name = "name")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    @XmlElement (name = "value")
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
