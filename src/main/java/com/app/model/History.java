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
    private int sum;
    private int sumObtained;
    private int userId;
    private LocalDate date;

    protected History() {
    }

    public History(int currencyFromId, int currencyToId, int sum, int sumObtained, int userId, LocalDate date) {
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

    public int getCurrencyFromId() {
        return currencyFromId;
    }

    public void setCurrencyFromId(int currencyFromId) {
        this.currencyFromId = currencyFromId;
    }

    public int getCurrencyToId() {
        return currencyToId;
    }

    public void setCurrencyToId(int currencyToId) {
        this.currencyToId = currencyToId;
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
