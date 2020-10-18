package com.globant.automation.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataManupulation {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Add days to the actual day.
     *
     * @param plusDays Days to be added.
     * @return Date in yyyy-MM-dd format with the added days
     */
    public static String getDatePlusDays(long plusDays) {
        DateTimeFormatter dateFormated = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime currentDate = LocalDateTime.now();
        return dateFormated.format(currentDate.plusDays(plusDays));
    }

    /**
     * Get the month from a given date, in spanish.
     *
     * @param date Date to translate.
     * @return Month.
     */
    public static String getMonthInSpanishFromADate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate currentDate = LocalDate.parse(date, formatter);
        Locale spanishLocale = new Locale("es", "ES");
        String monthInSpanish = currentDate.format(DateTimeFormatter.ofPattern("MMMM", spanishLocale));
        return monthInSpanish;
    }
}
