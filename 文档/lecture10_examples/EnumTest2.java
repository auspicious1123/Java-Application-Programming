/**
 * Test program for our second sample enumerations
 * @author Jeff Eppinger & Terry Lee
 */
public class EnumTest2 {
    /**
     * Private nested enumeration of months.
     * @author Jeff Eppinger & Terry Lee
     */
    private enum Month {
        JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), 
        OCTOBER(10), NOVEMBER(11), DECEMBER(12);

        private int number;

        private Month(int n) {
            number = n;
        }

        @Override
        public String toString() {
            return String.valueOf(number);
        }
    }

    /**
     * Private nested enumeration of days of the week.
     * @author Jeff Eppinger & Terry Lee
     */
    private enum DayOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

        @Override
        public String toString() {
            switch (this) {
            case SUNDAY:
            case SATURDAY:
                return "Weekend :-)";
            default:
                return "Weekday :-(";
            }
        }
    }

    /**
     * Main method of test program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        printDate(Month.FEBRUARY, DayOfWeek.THURSDAY);
        System.out.println("------");
        for (DayOfWeek dow : DayOfWeek.values()) {
            System.out.println(dow);
        }
    }

    /**
     * Sample method to demo compile-time checking of parameters.
     * @param month month value
     * @param dow day of the week value
     */
    private static void printDate(Month month, DayOfWeek dow) {
        System.out.println(month + " " + dow);
    }
}
