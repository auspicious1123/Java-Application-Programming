import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Example code for lecture 8.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class CSVReaderTest {
    /**
     * Simple test program to demo CSVReader class.
     * @param args arguments file name
     * @throws FileNotFoundException throws FileNotFoundException
     * @throws IOException throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length != 1) {
            System.out.println("Usage: java CSVReaderTest <filename>");
            System.exit(0);
        }

        FileReader fr = new FileReader(args[0]);
        CSVReader c = new CSVReader(fr);

        int lineNum = 0;
        boolean eof = false;

        while (!eof) {
            String[] values = c.readCSVLine();
            if (values == null) {
                eof = true;
            } else {
                lineNum = lineNum + 1;

                System.out.print("Line " + lineNum + "  " + values.length + " components:");
                for (int i = 0; i < values.length; i++) {
                    System.out.print(" \"" + values[i] + "\"");
                }
                System.out.println();
            }
        }

        c.close();
        fr.close();
    }
}
