/**
 * Example code for computing factorial iteratively.
 * @author Jeff Eppinger & Terry Lee
 */
public class FactorialIterative {
    /**
     * Factorial of n.
     * @param n input positive integer
     * @return factorial of n
     */
    public static int factorial(int n) {
        int answer = 1;

        for (int i = 1; i <= n; i++) {
            answer = answer * i;
        }

        return answer;
    }

    /**
     * Program to run factorial iteratively.
     * @param args argument for n value
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int nFact = factorial(n);
        System.out.println(nFact);
    }
}
