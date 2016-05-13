import java.util.Arrays;
/**
 * Example code for lecture 6.
 * Arrays class and its methods
 * Compare this with SortGrades example.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class SortGradesEasy {
    /**
     * A simple test program to sort int array.
     * This time uses Arrays class and its sort method
     * @param args arguments
     */
    public static void main(String[] args) {

        int[] grades = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            grades[i] = Integer.parseInt(args[i]);
        }

        Arrays.sort(grades);

        for (int i = 0; i < grades.length; i++) {
            System.out.println(grades[i]);
        }

    }
}
