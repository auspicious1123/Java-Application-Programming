/**
 * Test class to check StockHolding.
 *
 * @author Jeffrey Eppinger & Terry Lee
 */
public class StockHoldingTest {
    /**
     * Main method to test StockHolding.
     * @param args arguments
     */
    public static void main(String[] args) {
        StockHolding h = new StockHolding(args[0], Integer.parseInt(args[1]));
        System.out.println(h.ticker + ", " + h.shares + ", $" + h.price + " (" + h.name + ")");
    }
}
