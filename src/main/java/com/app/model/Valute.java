package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Valute {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;

    private String id;
    private String numCode;
    private String charCode;
    private int nominal;
    private String name;
    private String value;

    protected Valute(){};

    public Valute(String ID, String numCode, String charCode, int nominal, String name, String value) {
        this.id = ID;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return Id;
    }
    public String getNumCode() {
        return numCode;
    }
    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }
    public String getCharCode() {
        return charCode;
    }
    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }
    public int getNominal() {
        return nominal;
    }
    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Id + " " + id + " " + numCode + " " + charCode + " " + nominal + " " + name + " " + value + "\n";
    }
}
