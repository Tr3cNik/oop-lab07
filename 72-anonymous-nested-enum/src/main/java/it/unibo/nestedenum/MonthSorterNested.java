package it.unibo.nestedenum;

import java.util.Comparator;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    public enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private int days;

        private Month(int days) {
            this.days = days;
        }

        public static Month fromString(String stringMonth) {
            Month exceptedMonth = null;
            int monthCounter = 0;
            for(Month m: Month.values()) {
                if(m.name().toLowerCase().startsWith(stringMonth.toLowerCase())) {
                    exceptedMonth = m;
                    monthCounter++;
                }
            }
            if(monthCounter != 1) {
                throw new IllegalArgumentException(stringMonth + "is not valid");
            }
            return exceptedMonth;
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                return Integer.compare(Month.fromString(arg0).days, Month.fromString(arg1).days);
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {
           @Override
            public int compare(String arg0, String arg1) {
                return Month.fromString(arg0).compareTo(Month.fromString(arg1));
            } 
        };
    }
    /* 
    public class SortByMonthOrder implements Comparator<String> {
        @Override
        public int compare(String arg0, String arg1) {
            return Month.fromString(arg0).compareTo(Month.fromString(arg1));
        }
    }

    public class SortByDate implements Comparator<String> {
        @Override
        public int compare(String arg0, String arg1) {
            return Integer.compare(Month.fromString(arg0).days, Month.fromString(arg1).days);
        }
    }
    */
}
