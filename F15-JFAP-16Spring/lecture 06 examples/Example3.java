/**
 * Example code for lecture 6.
 * How about this? Does this look easier compared to Example1 and Example2?
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Example3 {
    /**
     * Calculates and returns hypotenuse of a and b.
     * @param a double value a
     * @param b double value b
     * @return double hypotenuse of a and b
     */
    public static double hypotenuse(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    /**
     * A test program for hypotenuse.
     * @param args arguments
     */
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = hypotenuse(a, b);
        System.out.println("c = " + c);
    }
}
