/**
 * Test class to test object instantiation and toString methods.
 *
 * @author Jeffrey Eppinger & Terry Lee
 */
public class ToStringTest {
    /**
     * Main method to test objects and their string representations.
     * @param args arguments
     */
    public static void main(String[] args) {
        Object o1 = new Square(3);
        Object o2 = new StockHolding("GOOG", 100);

        System.out.println(o1);
        System.out.println(o2);
    }
}
