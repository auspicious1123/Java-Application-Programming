/**
 * Example code for lecture 6.
 * In-depth look at array and sort algorithm introduced in lecture 5
 * @author Jeffrey Eppinger & Terry Lee
 */
public class SortStrings {
    /**
     * A simple test program to sort array of String objects.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Before sort:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i]);
        }

        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[i].compareTo(args[j]) > 0) {
                    // Swap args[i] & args[j]
                    String temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }

        System.out.println("After sort:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i]);
        }
    }
}
