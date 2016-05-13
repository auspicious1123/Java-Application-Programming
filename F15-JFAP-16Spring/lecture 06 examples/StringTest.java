/**
 * Example code for lecture 6.
 * String and its methods
 * @author Jeffrey Eppinger & Terry Lee
 */
public class StringTest {
    /**
     * A simple program to see String objects and methods.
     * @param args arguments
     */
    public static void main(String[] args) {
        int i = 4;
        double d;
        String middle = "Lee";
        String m1 = middle;
        String m2 = args[0];

        // Remember Memory?
        System.out.println(i);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m1 == middle);
        System.out.println(m1 == m2);
        System.out.println(m1.equals(m2));
    }
}
