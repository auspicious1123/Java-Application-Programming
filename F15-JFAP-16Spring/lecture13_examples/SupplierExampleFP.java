import java.util.function.Supplier;

/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class SupplierExampleFP {

    /**
     * Gets output from a Supplier functional interface.
     * @param supplier supplier functional interface as lambda expression
     */
    private static void print(Supplier<Integer> supplier) {
        System.out.println(supplier.get());
    }

    /**
     * Simple program to demo Supplier functional interface with lambda expression.
     * @param args arguments
     */
    public static void main(String[] args) {
        String s = "Donald Trump says you are fired.";
        print(() -> s.length());
    }

}
