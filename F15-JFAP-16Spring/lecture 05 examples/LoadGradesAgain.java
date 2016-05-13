/**
 * Example code for array and for loop and for-each loop.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class LoadGradesAgain {
    /**
     * Loads grades into an array of int.
     * @param args arguments array of grades
     */
    public static void main(String[] args) {
        int[] grades = new int[args.length];
        for (int i=0; i<args.length; i++) {
            grades[i] = Integer.parseInt(args[i]);
        }
        // insert something interesting here using for-each loop.
        for (int g : grades) {
            System.out.println(g);
        }
    }
}

