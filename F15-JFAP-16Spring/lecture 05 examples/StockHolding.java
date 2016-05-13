/**
 * Stockholding example code.
 * @author Jeffrey Eppinger
 */
public class StockHolding {
    String ticker;
    int    shares;
    String name;
    float  price;

    /**
     * This is the constructor method.
     * @param newTicker ticker
     * @param newShares share price
     */
    public StockHolding(String newTicker, int newShares) {
    	ticker = newTicker;
    	shares = newShares;
    	StockQuote sq = new StockQuote(ticker);
    	price = sq.getPrice();
    	name  = sq.getName();
    }
}
