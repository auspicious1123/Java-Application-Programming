/**
 * Example code for array and for loop.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class PrintArgs {
    /**
     * print an array of arguments using for loop.
     * @param args argument array
     */
    public static void main(String[] args) {
        // Prints out the arguments
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]=\"" + args[i] + "\"");
        }
    }
}
