import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Print even numbers in a list of positive integers.
 * @param numbers list of positive integers
 */
public class PredicateExampleFP {

    /**
     * Takes a list of positive integers and Predicate Functional Interface to perform some operations.
     * @param numbers list of positive integers
     * @param condition Predicate functional interface
     */
    private static void conditionCheck(List<Integer> numbers, Predicate<Integer> condition) {
        for(Integer i : numbers) {
            // actually test the values using Predicate functional interface passed
            if(condition.test(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * Takes a list of positive integers and perform some operations in Java 8.
     * Using Predicate Functional Interface
     * @param args arguments
     */
    public static void main(String[] args) {
        List<Integer> positives = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // pass implementation of Predicate functional interface (lambda expression)
        conditionCheck(positives, x -> x % 2 == 0);
        System.out.println();

        // pass implementation of Predicate functional interface (lambda expression)
        conditionCheck(positives, x -> x % 2 != 0);
        System.out.println();

        // pass implementation of Predicate functional interface (lambda expression)
        conditionCheck(positives, x -> x > 5);
    }

}
