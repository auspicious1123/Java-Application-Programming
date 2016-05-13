/**
 * Example code for lecture 6.
 * What does this do?
 * Hint: Newton's method
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Example1 {
    /**
     * A simple mysterious program.
     * @param args arguments
     */
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double sum = a * a + b * b;

        double c = sum / 2;
        double previousC = 0;

        while (c != previousC) {
            System.out.println("c = " + c);
            previousC = c;
            c = (sum / c + c) / 2;
        }

        System.out.println("c = " + c);
    }
}
