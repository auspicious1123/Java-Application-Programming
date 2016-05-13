/**
 * Example code for while loop.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class ReverseDigits {
    /**
     * Reverse an int. 
     * @param args arguments
     */
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        while (x > 0) {
            int digit = x % 10;
            System.out.print(digit);
            x = x / 10;
        }
        System.out.println();
    }
}
