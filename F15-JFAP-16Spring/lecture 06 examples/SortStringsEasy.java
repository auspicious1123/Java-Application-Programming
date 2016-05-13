import java.util.Arrays;

/**
 * Example code for lecture 6.
 * In-depth look at array and sort algorithm introduced in lecture 5
 * @author Jeffrey Eppinger & Terry Lee
 */
public class SortStringsEasy {
    /**
     * A simple test program to sort array of String objects.
     * This time uses Arrays class and its sort method
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Before sort:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i]);
        }

        Arrays.sort(args);

        System.out.println("After sort:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i]);
        }
    }
}
