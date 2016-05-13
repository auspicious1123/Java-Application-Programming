/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class FinalVariables {

    /**
     * Prints text as many as count.
     * @param text the text to print
     * @param count how many times to print
     */
    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
            }
        };
        new Thread(r).start();
    }

    /**
     * Version 2 of printing as many as count but does not work.
     * @param text text to print
     * @param count how many times to print
     */
    public static void repeatMessage2(String text, int count) {
        Runnable r = () -> {
            while (count > 0) {
                // local variables used here should be final or effectively final
                //count--;
                System.out.println(text);
            }
        };
        new Thread(r).start();
    }

    /**
     * Simple test program 
     * to show local variables used in lambda must be final or effectively final.
     * @param args arguments
     */
    public static void main(String[] args) {
        repeatMessage("Hello", 1000);
    }

}
