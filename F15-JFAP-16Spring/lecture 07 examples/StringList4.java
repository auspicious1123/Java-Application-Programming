import java.util.ArrayList;
import java.util.List;

/**
 * Example code for lecture 7.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class StringList4 {
    /**
     * Simple test program of ArrayList used before Java 5.
     * On Eclipse, this will compile but there are warnings.
     * @param args arguments
     */
    public static void main(String[] args) {
        // notice that there is no Generics
        List list = new ArrayList();

        String line = TextPrompter.promptLine("String>", null);
        while (line != null) {
            list.add(line);
            line = TextPrompter.promptLine("String>", null);
        }

        for (Object o : list) {
            // notice that explicit cast is necessary
            String s = (String) o;
            System.out.println(s);
        }
    }
}
