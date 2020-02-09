package com.app.model;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "History")
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int currencyFromId;
    private int currencyToId;
    private double sum;
    private double sumObtained;
    private int userId;
    private LocalDate date;

    protected History() {
    }

    public History(int currencyFromId, int currencyToId, double sum, double sumObtained, int userId, LocalDate date) {
        this.currencyFromId = currencyFromId;
        this.currencyToId = currencyToId;
        this.sum = sum;
        this.sumObtained = sumObtained;
        this.userId = userId;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCurrencyFromId(Long id) {
        return currencyFromId;
    }

    public void setCurrencyFromId(int currencyFromId) {
        this.currencyFromId = currencyFromId;
    }

    public int getCurrencyToId(Long id) {
        return currencyToId;
    }

    public void setCurrencyToId(int currencyToId) {
        this.currencyToId = currencyToId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
