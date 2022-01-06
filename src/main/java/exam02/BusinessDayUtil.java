package exam02;

import java.time.LocalDate;

/**
 * An util for getting business day
 */
public class BusinessDayUtil {

    /**
     * To check a particular date if it's weekend of the specific exchange.
     * @param exchange exchange
     * @param date the date need to check
     * @return if the date is weekend, return true, otherwise false.
     */
    public static boolean isWeekend(String exchange, LocalDate date) {

        throw new RuntimeException("Please implement this function");
    }

    /**
     * To get the most recent business day by given exchange and date.
     * If the given date is a business day, will return it as the result. Otherwise,
     * return the business date before the given date.
     * @param exchange
     * @param date
     * @return the most recent business day
     */
    public static LocalDate getMostRecentBusinessDay(String exchange, LocalDate date) {

        throw new RuntimeException("Please implement this function");
    }
}
