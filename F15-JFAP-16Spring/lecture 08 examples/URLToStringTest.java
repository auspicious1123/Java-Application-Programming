import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Example code for lecture 8.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class URLToStringTest {
    /**
     * Constant for max size of 4 MB.
     */
    private static final int MAX_SIZE = 4 * 1024 * 1024;

    /**
     * Take url string and return the data as string.
     * @param urlString url string value
     * @return String representation of the response data
     */
    private static String urlToString(String urlString) {
        try {
            URL url = new URL(urlString);
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder b = new StringBuilder();
            boolean eof = false;

            while (!eof && b.length() < MAX_SIZE) {
                String line = br.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    b.append(line);
                    b.append('\n');
                }
            }

            br.close();
            return b.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Simple program to demo run this class.
     * @param args arguments url
     */
    public static void main(String[] args) {
        System.out.println(urlToString(args[0]));
    }
}
