/**
 * StockHolding class that has stock information.
 *
 * @author Jeffrey Eppinger & Terry Lee
 */
public class StockHolding {
    /**
     * ticker of stock.
     */
    String ticker;
    /**
     * number of shares of stock.
     */
    int shares;
    /**
     * name of stock.
     */
    String name;
    /**
     * price of stock.
     */
    float price;

    /**
     * Constructor with ticker and number of shares.
     *
     * @param newTicker
     *            ticker of stockquote
     * @param newShares
     *            number of shares
     */
    public StockHolding(String newTicker, int newShares) {
        ticker = newTicker;
        shares = newShares;
        StockQuote sq = new StockQuote(ticker);
        price = sq.getPrice();
        name = sq.getName();
    }

    /**
     * Returns string representation of StockHolding object.
     *
     * @return a string representation of StockHolding object
     */
    public String toString() {
        return "Stock Holding of " + shares + " shares of " + name + " valued at " + shares * price;
    }
}
