/**
 * Example code for lecture 6.
 * Does this look easier to understand compared to Example1?
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Example2 {
    /**
     * A simple mysterious program.
     * @param args arguments
     */
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Math.sqrt(a * a + b * b);
        System.out.println("c = " + c);
    }
}
