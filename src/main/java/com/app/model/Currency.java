package com.app.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Table(name = "Currencies")
@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String numCode;
    private String charCode;
    private int nominal;
    private String name;
    private double value;
    private LocalDate date;

    protected Currency(){};

    public Currency(String numCode, String charCode, int nominal, String name, double value, LocalDate date) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        this.date = date;
    }

    public Long getId() {
        return id;
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

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id + " " + numCode + " " + charCode + " " + nominal + " " + name + " " + value + " " + date;
    }
}
