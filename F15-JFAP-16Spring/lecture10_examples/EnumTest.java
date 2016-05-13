/**
 * Test program for our first sample enumerations
 * @author Jeff Eppinger & Terry Lee
 */
public class EnumTest {
    /**
     * Main method of test program.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Month.FEBRUARY);
        System.out.println(DayOfWeek.THURSDAY);

        printDate(Month.APRIL, DayOfWeek.SUNDAY);
    }

    /**
     * Sample method to demo compile-time checking of parameters.
     * @param month
     * @param dow
     */
    private static void printDate(Month month, DayOfWeek dow) {
        System.out.println(month + " " + dow);
    }
}
