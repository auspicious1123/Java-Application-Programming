import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class FunctionExampleFP {

    /**
     * Method to apply Function functional interfaces with a given value.
     * @param value value to use in apply method
     * @param functionToApply Function functional interface to use
     * @return return double value
     */
    private static double applyFunction(double x, Function<Double, Double> functionToApply) {
        return functionToApply.apply(x);
    }

    /**
     * Simple program to demonstrate how to use lambda expressions of Function functional interface.
     * @param args arguments
     */
    public static void main(String[] args) {
        List<Double> greaterThanTwo = Arrays.asList(2.0, 3.0, 4.0, 5.0, 6.0, 7.0);
        for (Double i : greaterThanTwo) {
            double squared = applyFunction(i, x -> x * x);
            System.out.println(i + " squared is " + squared);
            double sqRoot = applyFunction(squared, x -> {
                double temp;
                double squareRoot = x / 2;

                do {
                    temp = squareRoot;
                    squareRoot = (temp + (x / temp)) / 2;
                } while ((temp - squareRoot) != 0);

                return squareRoot;
            });
            System.out.println("Square root of " + squared + " is " + sqRoot + "\n");
        }
    }

}