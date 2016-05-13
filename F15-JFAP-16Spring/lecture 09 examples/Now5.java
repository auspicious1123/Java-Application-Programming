import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Example code for lecture 9.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Now5 {
    /**
     * Simple program to print date using SimpleDateFormat.
     * @param args arguments
     */
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy @ HH:mm");
        Date d = new Date();
        System.out.println(sdf.format(d));
    }
}
