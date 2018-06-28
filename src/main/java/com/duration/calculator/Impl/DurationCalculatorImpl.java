package com.duration.calculator.Impl;

import com.duration.calculator.DurationCalculator;
import com.duration.calculator.Month;

import java.util.logging.Logger;

public class DurationCalculatorImpl implements DurationCalculator {
    private static final int DATE_LENTH = 10;
    private Logger log = Logger.getLogger("DurationCalculatorImpl.class");

    public boolean validateInput(String dateFrom , String dateTo){

        if(isDateValidFormat(dateFrom)){
            log.info(" Start Date is valid format ");
            if(isDateValidFormat(dateTo)){
                log.info(" End Date is valid format too ");

                return true;

            }else{
                log.info(" End Date should be of the format dd/mm/yyyy and not after 01/01/2999");
            }
        }else{
            log.info(" Start Date should be of the format dd/mm/yyyy and not before 01/01/1901");
        }
        return false;
    }

    private boolean isDateValidFormat(String date){
        if(date.length() < DATE_LENTH){
            return false;
        }
        String regexExpression = "(0[1-9]|[12][0-9]|3[01])[- \\/.](0[1-9]|1[012])[- \\/.](19|2[0-9])\\d\\d";
        if(date.matches(regexExpression)){
           return true;
        }
        return false;
    }

    public int calculateDays(String startDate, String endDate){

        String[] startDateSplitArr = startDate.split("\\/");
        int startDay = Integer.parseInt(startDateSplitArr[0]);
        int startMonth = Integer.parseInt(startDateSplitArr[1]);
        int startYear = Integer.parseInt(startDateSplitArr[2]);
        log.info(" day month year "+startDay +" "+startMonth+" "+startYear);

        String[] endDateSplitArr = endDate.split("\\/");
        int endDay = Integer.parseInt(endDateSplitArr[0]);
        int endMonth = Integer.parseInt(endDateSplitArr[1]);
        int endYear = Integer.parseInt(endDateSplitArr[2]);
        log.info(" day month year "+endDay +" "+endMonth+" "+endYear);

        int finaDaysElapsed = 0;
        int daysElapsed = endDay - startDay;
        if(endYear < startYear) return 0;

        if( endYear - startYear < 1){
            if( endMonth - startMonth < 1){
                if( daysElapsed <= 1){
                    return 0;
                }else{
                    finaDaysElapsed = daysElapsed;
                }
            }
        }else {
           finaDaysElapsed = calculateDaysElapsed(startYear,endYear,startMonth,endMonth,startDay,endDay);
        }
        log.info(" Final days elapsed "+finaDaysElapsed);
        return finaDaysElapsed;
    }

    public int calculateDaysElapsed(int startYear , int endYear, int startMonth, int endMonth, int startDaysPassed, int endDaysPassed){
        int daysElapsed = 0;
        int monthCount = endMonth - startMonth -  1;
        int daysStartMonth = Month.valueOf(startMonth).getValue() - startDaysPassed;
        int daysEndMonth = endDaysPassed;
        for(int i= 1; i<= monthCount;i++){
            daysEndMonth = daysEndMonth + (Month.valueOf(startMonth + i).getValue());
        }
        daysElapsed = calculateDaysInYear(startYear,endYear,daysStartMonth, daysEndMonth);
        return daysElapsed;
    }

    private int calculateDaysInYear(int startYear, int endYear, int daysElapsedInYear, int daysRemInYear){
        int daysElapsed = 0;
        int yearCount = (endYear - startYear) -  1;
        int daysStartYear = getDaysInYear(startYear) - daysElapsedInYear;
        int daysEndYear = daysRemInYear;

        for(int i= 1; i<=yearCount;i++){
            daysEndYear = daysEndYear + getDaysInYear(startYear + i);
        }
        daysElapsed = daysEndYear + daysStartYear;
        log.info(" days elapsed In year after deducting days "+daysElapsed);
        return daysElapsed;
    }

    private int getDaysInYear(int year){
        if(year % 400 == 0){
            return 366;
        }else{
            return 365;
        }
    }
}
