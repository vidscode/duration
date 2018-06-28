package com.duration.calculator;

import com.duration.calculator.Impl.DurationCalculatorImpl;

import java.util.Scanner;
import java.util.logging.Logger;

public class CalculateDurationMain {

    /**
     * Build a command line tool to calculate the number of full days elapsed in
     * between the start and end dates of an event. The first and the last day are considered partial
     * days and never counted. Following this logic, an event that has run from 07/11/1972 and 08/11/1972
     * should return 0, because there are no fully elapsed days contained in between those dates, and
     * 01/01/2000 to 03/01/2000 should return 1. The solution needs to cater for all valid dates between
     * 01/01/1901 and 31/12/2999.
   */

    public static Logger log = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        DurationCalculator calculator = new DurationCalculatorImpl();
        Scanner scanner = new Scanner(System.in);
        log.info("************ Days Elapsed ***************************");
        log.info(" Enter the Start Date : ");
        String startDate = scanner.nextLine();
        log.info(" Enter the End Date : ");
        String endDate = scanner.nextLine();
        log.info(" StartDate = "+startDate + " End Date = "+endDate);

        calculator.validateInput(startDate, endDate);
        calculator.calculateDays(startDate,endDate);
    }

    /**
     * validate to check the date is in the format and within the range(01/01/1901 and 31/12/2999)
     * @return true if date is right format and within the range
     */
    public boolean isDateValid(String startDate, String endDate){

        return true;
    }

    public int findElapsedDays(String startDate, String endDate){
        return 0;
    }
}
