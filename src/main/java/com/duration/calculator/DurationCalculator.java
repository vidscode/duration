package com.duration.calculator;

public interface DurationCalculator {

    boolean validateInput(String dateFrom , String dateTo);
    int calculateDays(String dateFrom , String dateTo);
    int calculateDaysElapsed(int startYear, int endYear, int startMonth, int endMonth, int startDaysPassed, int endDaysPassed);
}
