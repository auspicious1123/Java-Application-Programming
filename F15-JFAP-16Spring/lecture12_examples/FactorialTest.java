/**
 * Example code for advantages of exceptions.
 * @author Terry Lee
 */
public class FactorialTest {
    /**
     * Program to show catching different exceptions.
     * @param args n value for factorial computation
     */
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            int nFact = FactorialIterative.factorial(n);
            System.out.println(nFact);
            int nFact2 = FactorialRecursive.factorial(n);
            System.out.println(nFact2);
        } catch (NumberFormatException e) {
            System.out.println("Houston we have a problem!");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
