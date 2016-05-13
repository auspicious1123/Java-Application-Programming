/**
 * Example code for array, for loop, and sorting.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class SortGrades {
    /**
     * Parse grades from arguments and sort an array of grade.
     * @param args array of grade arguments
     */
    public static void main(String[] args) {
        // Parse args to get int values
        int[] grades = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            grades[i] = Integer.parseInt(args[i]);
        }

        // Here's something interesting (sorting the grades)
        for (int i = 0; i < grades.length; i++) {
            for (int j = i + 1; j < grades.length; j++) {
                if (grades[j] < grades[i]) {
                    int temp = grades[i];
                    grades[i] = grades[j];
                    grades[j] = temp;
                }
            }
        }

        // Print out the grades
        for (int i = 0; i < grades.length; i++) {
            System.out.println(grades[i]);
        }
    }
}
