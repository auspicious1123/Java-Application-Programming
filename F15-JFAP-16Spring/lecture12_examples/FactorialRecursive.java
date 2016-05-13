/**
 * Example code for computing factorial recursively.
 * @author Jeff Eppinger & Terry Lee
 */
public class FactorialRecursive {
    /**
     * Factorial of n.
     * @param n input positive integer
     * @return factorial of n
     */
    public static int factorial(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("only positive numbers");
        }
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Program to run factorial recursively.
     * @param args argument for n value
     */
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            int nFact = factorial(n);
            System.out.println(nFact);
        } catch(NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Only numbers please");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Non-positive values make my brain hurt");
            e.printStackTrace(); 
        }
    }
}
