package com.app.util;

import java.time.LocalDate;

public class Util {

    public static LocalDate yesterdayDate() {
        return LocalDate.now().minusDays(1L);
    }
}
