/**
 * Example code for an array of objects and for loop and sorting.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class StockHoldingSortTest {
    /**
     * Build StockHolding objects and sort them using nested for loops.
     * @param arguments
     */
    public static void main(String[] args) {
        StockHolding[] ha = new StockHolding[5];
        ha[0] = new StockHolding("IBM", 100);
        ha[1] = new StockHolding("MSFT", 200);
        ha[2] = new StockHolding("CSCO", 300);
        ha[3] = new StockHolding("GOOG", 400);
        ha[4] = new StockHolding("EMC", 500);

        for (int i = 0; i < ha.length; i++) {
            for (int j = i + 1; j < ha.length; j++) {
                if (ha[j].price * ha[j].shares < ha[i].price * ha[i].shares) {
                    StockHolding temp = ha[i];
                    ha[i] = ha[j];
                    ha[j] = temp;
                }
            }
        }

        for (int i = 0; i < ha.length; i++) {
            System.out.printf("%5s, shares=%6d, price=$%7.2f, value=$%,10.2f\n", ha[i].ticker, ha[i].shares,
                    ha[i].price, ha[i].price * ha[i].shares);
        }
    }
}
