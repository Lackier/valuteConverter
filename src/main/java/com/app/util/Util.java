package com.app.util;

import com.app.model.Currency;

import java.time.LocalDate;

public class Util {

    public static LocalDate yesterdayDate() {
        return LocalDate.now().minusDays(1L);
    }

    public static LocalDate todayDate() {
        return LocalDate.now();
    }

    public static double getJavasDouble(String number) {
        number = number.replace(',', '.');
        return Double.parseDouble(number);
    }

    public static Currency getRuble() {
        return new Currency(
                "000",
                "RUR",
                1,
                "Русский рубль",
                1,
                Util.yesterdayDate()
        );
    }
}
