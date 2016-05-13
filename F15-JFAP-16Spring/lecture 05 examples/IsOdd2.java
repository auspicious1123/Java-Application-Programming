/**
 * Example code for if-else.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class IsOdd2 {
    /**
     * Checks if integer is odd or not.
     * @param i int value to check
     * @return true if i is odd and false if not
     */
    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    /**
     * Find if an integer is odd or not.
     * @param args arugments
     */
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println(isOdd(x));
    }

}
