/**
 * Example code for if-else.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class IsOdd {
    /**
     * Find if an integer is odd or not.
     *
     * @param args arugments
     */
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        if (x % 2 == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
