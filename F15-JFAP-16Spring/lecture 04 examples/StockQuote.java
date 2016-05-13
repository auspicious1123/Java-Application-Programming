import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

/**
 * StockQuote Class Example.
 *
 * date: February 3, 2000
 * modified: January 8, 2002
 * @author Jeffrey Eppinger (eppinger@cmu.edu)
 */
public class StockQuote implements Runnable {
    /**
     * The ticker for the stock.
     */
    private String ticker;
    /**
     * The stock price.
     */
    private String price;
    /**
     * Today's delta in the stock price.
     */
    private String change;
    /**
     * The date of the stock quote.
     */
    private String date;
    /**
     * The time of the stock quote.
     */
    private String time;
    /**
     * The name of the stock.
     */
    private String name;
    /**
     * Support for threading (see below).
     */
    private boolean keepRunning = true;

    /**
     * The URL used to get the stock quote.
     */
    private URL url;

    /**
     * Count of the number of quotes we've done.
     */
    private static int quoteCount = 0;

    /**
     * An internal routine that reads the URL and stuff the data into instance variables.
     * @throws IOException IOexception might be thrown
     */
    private void readURLData() throws IOException {
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is);
        CSVReader c = new CSVReader(isr);
        String[] values = c.readCSVLine();
        if (values.length < 5) {
            c.close();
            throw new IOException("Format error reading line, only " + values.length + " items!");
        }

        ticker = values[0];
        price = values[1];
        change = values[4];
        date = values[2];
        time = values[3];
        name = values[5];

        quoteCount = quoteCount + 1;

        c.close();
        isr.close();
        is.close();
    }

    /**
     * constants used to construct URL string in constructor.
     */
    private final String urlHeader = "http://quote.yahoo.com/d/quotes.csv?s=";
    /**
     * constant used to construct URL string in constructor.
     */
    private final String urlTrailer = "&f=sl1d1t1c1nohgv&e=.csv";

    /**
     * Constructor takes ticker.
     * @param ticker ticker of stock
     */
    public StockQuote(String ticker) {
        String urlString = urlHeader + ticker + urlTrailer;

        try {
            url = new java.net.URL(urlString);
        } catch (IOException e) {
            System.out.println("IOException" + e);
            System.exit(0);
        }
    }

    /**
     * An instance method to provide a current quote for the stock, as a string.
     * @return string include the ticker, price change and quote date/time
     */
    public String currentQuote() {
        try {
            readURLData();
        } catch (IOException e) {
            System.out.println("IOException" + e);
            System.exit(0);
        }

        String answer = ticker + ' ' + price + ' ' + change + " at " + date + ' ' + time;

        return answer;
    }

    /**
     * This method returns a current price for the ticker.
     * @return current price for the ticker
     */
    public float getPrice() {
        try {
            readURLData();
        } catch (IOException e) {
            System.out.println("IOException");
            System.exit(0);
        }
        return Float.parseFloat(price);
    }

    /**
     * returns a name for the ticker.
     * @return String value of ticker name
     */
    public String getName() {
        if (name == null) {
            try {
                readURLData();
            } catch (IOException e) {
                System.out.println("IOException");
                System.exit(0);
            }
        }

        return name;
    }

    /**
     * returns a change in the price for the ticker.
     * @return string value of a change in the price
     */
    public String getChange() {
        if (name == null) {
            try {
                readURLData();
            } catch (IOException e) {
                System.out.println("IOException");
                System.exit(0);
            }
        }

        return change;
    }

    /**
     * Returns quote count value.
     * @return int value of quote count
     */
    public static int getQuoteCount() {
        return quoteCount;
    }

    /**
     * Supports for printing current quotes from background thread.
     */
    public void run() {
        while (keepRunning) {
            String quote = currentQuote();
            if (keepRunning) {
                System.out.println(quote);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * make thread running flag false.
     */
    public void stopRunning() {
        keepRunning = false;
    }

    /**
     * A simplified version of CSV Reader.
     *
     * Subclass of a BufferedReader to handle a character stream that consists
     * of comma separated values (CSVs)
     *
     * Provides an additional instance method, readCSVLine(), that parses lines
     * into substrings. The substrings are separated by comma in the original
     * input stream. The readCSVLine() method returns an array of references to
     * Strings. The Strings are the values from the line that were separated by
     * commas. If a value was surrounded by quotes, the quotes are removed.
     *
     * Limitations: Spaces before or after the commas are not removed. In the
     * first and last quote are removed from a value. Embedding commas in a
     * quoted value is not handled properly. (In this case, the commas will
     * separate the values and the quotes will not be removed from the ends of
     * those values.
     *
     * Date: June 10, 2001
     * @author Jeffrey Eppinger (jle@cs.cmu.com)
     */
    private static class CSVReader extends BufferedReader {

        /**
         * The constructor just initializes the superclass.
         * @param in reader argument
         */
        CSVReader(Reader in) {
            super(in);
        }

        /**
         * This is the only additional method.
         * It uses readLine from the superclass to get a line
         * but returns the comma separated values as in an array of strings.
         * At the end of the file, readCSVLine returns null (just as readLine does).
         * @return string array of values
         * @throws IOException IOException might be thrown
         */
        public String[] readCSVLine() throws IOException {

            // Get a line by calling the superclass's readLine method
            String line = super.readLine();

            // If we're at the end of the file, readLine returns null
            // so we return null.
            if (line == null) {
                return null;
            }

            // Count up the number of commas
            int commaCount = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    commaCount = commaCount + 1;
                }
            }

            // Allocate an array of the necessary size to return the strings
            String[] values = new String[commaCount + 1];

            // In a loop, set beginIndex and endIndex to the start and end
            // positions of each argment and then use the substring method
            // to create strings for each of the comma separate values

            // Start beginIndex at the beginning of the String, position 0
            int beginIndex = 0;

            for (int i = 0; i < commaCount; i++) {

                // set endIndex to the position of the (next) comma
                int endIndex = line.indexOf(',', beginIndex);

                // if the argument begins and ends with quotes, remove them

                if (line.charAt(beginIndex) == '"' && line.charAt(endIndex - 1) == '"') {

                    // If we made it here, we have quotes around our string.
                    // Add/substract one from the start/end of the args
                    // to substring to get the value. (See else comment
                    // below for details on how this works.)

                    values[i] = line.substring(beginIndex + 1, endIndex - 1);

                } else {

                    // If we name it here, we don't have quotes around
                    // our string. Take the substring of this line
                    // from the beginIndex to the endIndex. The substring
                    // method called on a String will return the portion
                    // of the String starting with the beginIndex and up
                    // to but not including the endIndex.

                    values[i] = line.substring(beginIndex, endIndex);
                }

                // Set beginIndex to the position character after the
                // comma. (Remember, endIndex was set to the position
                // of the comma.)
                beginIndex = endIndex + 1;
            }

            // handle the value that's after the last comma
            if (line.charAt(beginIndex) == '"' && line.charAt(line.length() - 1) == '"') {
                values[commaCount] = line.substring(beginIndex + 1, line.length() - 1);
            } else {
                values[commaCount] = line.substring(beginIndex, line.length());
            }

            return values;
        }
    }

}
