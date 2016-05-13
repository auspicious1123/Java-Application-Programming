import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Example code for lecture 9.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Now7 {
    /**
     * Simple program to use Date along with Locale and DateFormat (Long).
     * @param args arguments
     */
    public static void main(String[] args) {
        String languageCode = args[0];
        Locale locale = new Locale(languageCode);
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        Date d = new Date();
        System.out.println(df.format(d));
    }
}
