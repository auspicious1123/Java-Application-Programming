/**
 * Example code for while loop.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class IsPowerOfTwoAgain {
    /**
     * Checks if int value is power of two.
     * @param args arguments
     */
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        boolean answer = false;
        for (int p = 1; p <= x; p = p * 2) {
            System.out.println("Testing " + p);
            if (p == x) {
                answer = true;
            }
        }
        System.out.println("Answer is: " + answer);
    }
}
