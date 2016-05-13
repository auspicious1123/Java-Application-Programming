import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Example code for lecture 8.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class FilePrint {
    /**
     * Simple program to print out characters of a file.
     * @param args arugments file name
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Program to print out any given file as characters.");
            System.out.println("Usage: java FilePrint filename");
            return;
        }

        try {
            FileReader fr = new FileReader(args[0]);

            // Count the numbers of characters printed per line in column
            // variable:
            int column = 0;

            // Read the first character:
            int c = fr.read();

            while (c != -1) {
                // Characters that are less than space (' ') are not printable.
                // Convert them to the control representation (^A, ^B, etc.):
                if (c >= ' ') {
                    System.out.print(" '" + (char) (c) + "' ");
                } else {
                    System.out.print(" '^" + (char) (c + '@') + "'");
                }

                // After printing 10 characters on a line, go to the next:
                column = column + 1;
                if (column > 9) {
                    System.out.println();
                    column = 0;
                }

                // Read the next character:
                c = fr.read();
            }

            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " was not found");
        } catch (IOException e) {
            System.out.println();
            System.out.println("IOException!");
        }
    }
}
