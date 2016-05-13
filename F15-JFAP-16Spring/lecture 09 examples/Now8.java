import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Example code for lecture 9.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Now8 {
    /**
     * Simple program to use Date along with Locale (both language and country code).
     * @param args arguments
     */
    public static void main(String[] args) {
        String languageCode = args[0];
        String countryCode = args[1];
        Locale locale = new Locale(languageCode, countryCode);
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        Date d = new Date();
        System.out.println(df.format(d));
    }
}
