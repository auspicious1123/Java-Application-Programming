import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Example code for lecture 7.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class StringSort2 {
    /**
     * Simple test program to show ArrayList of String.
     * And the usage of Comparator in Collections.sort
     * @param args arguments
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (String s : args) {
            list.add(s);
        }

        System.out.println("Before sort:");
        for (String s : list) {
            System.out.println("    " + s);
        }

        Collections.sort(list, new MyComparator());

        System.out.println("After sort:");
        for (String s : list) {
            System.out.println("    " + s);
        }
    }

    /**
     * Comparator interface implementation example.
     * @author Jeffrey Eppinger & Terry Lee
     */
    private static class MyComparator implements Comparator<String> {
        /**
         * Implementation of compare method.
         * @param s1 String to compare
         * @param s2 Another String to compare
         * @return negative, zero, or positive values
         */
        @Override
        public int compare(String s1, String s2) {
            return -s1.compareToIgnoreCase(s2);
        }
    }
}
