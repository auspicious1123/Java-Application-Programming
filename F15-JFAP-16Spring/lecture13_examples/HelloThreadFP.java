/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class HelloThreadFP {

    /**
     * Simple program to demo of using lambda expressions with no param and multiple statements.
     * @param args arguments
     */
    public static void main(String[] args) {
        // one statement in the lambda body
        //Thread t = new Thread(() -> System.out.println("Hello from a runnable after Java 8!"));

        // multiple statements in the lambda body
        Thread t = new Thread(() -> {
            System.out.println("Hello from a runnable after Java 8!");
            System.out.println("Let's go to Shichuan Gourmet to have Kung Pao Chicken");
        });
        t.start();
    }
}
