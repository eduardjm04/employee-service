package com.example.employee_service.utils;

import java.time.LocalDate;
import java.time.Period;

public final class DateUtils {

    private DateUtils() {
    }

    public static Integer calculateAge(LocalDate bornDate) {

        if (bornDate == null) {
            return null;
        }

        return Period.between(bornDate, LocalDate.now()).getYears();
    }
}
