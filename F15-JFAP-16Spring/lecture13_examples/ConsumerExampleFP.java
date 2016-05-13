import java.util.ArrayList;
import java.util.List;

/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class ConsumerExampleFP {

    /**
     * Simple program to show Consumer Functional Interface usage.
     * @param args arguments
     */
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        numbers.forEach(e -> System.out.println(e));
    }

}
