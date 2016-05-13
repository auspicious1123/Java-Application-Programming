/**
 * Example code for lecture 9.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Now2 {
    /**
     * Simple program to print milliseconds since January 1, 1970.
     * with a DecimalFormat
     * @param args arguments
     */
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        java.text.DecimalFormat df;
        df = new java.text.DecimalFormat("#,###");
        System.out.println(df.format(now));
    }
}
