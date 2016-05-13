/**
 * Class to test StockQuote class.
 *
 * @author Jeffrey Eppinger & Terry Lee
 */
public class StockQuoteTest {
    /**
     * Main method to test StockQuote class.
     * @param args arguments
     */
    public static void main(String[] args) {
        StockQuote sq = new StockQuote(args[0]);
        System.out.println("      " + sq.getName() + "   " + sq.currentQuote());
    }
}
