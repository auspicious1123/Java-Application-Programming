/**
 * Example code for array and for loop.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class LoadGrades {
    /**
     * Loads grades into an array of int.
     * @param args arguments array of grades
     */
    public static void main(String[] args) {
        int[] grades = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            grades[i] = Integer.parseInt(args[i]);
        }

        // insert something interesting here

        for (int i = 0; i < grades.length; i++) {
            System.out.println(grades[i]);
        }
    }
}
