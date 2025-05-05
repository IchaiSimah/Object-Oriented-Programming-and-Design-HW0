package homework0;

import java.io.*;
import java.util.StringTokenizer;

    /**
     * Reads integers from the provided FileReader, computes per-line averages,
     * and prints overall statistics including total count and percentage of
     * positive, negative, and zero values.
     *
     * @param in a FileReader for the input text file containing tokens and integers
     * @requires in != null && the underlying file exists and is readable
     * @effect Prints per-line average of integers and overall statistics
     * @throws IOException if an I/O error occurs while reading lines
     */
public class FileStats {
    public static void printFileStats(FileReader in) throws IOException {

        // count number of numbers in the file

        int totalNumbers = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        try (BufferedReader reader = new BufferedReader(in)) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line, " ;?{}[]=+_!@#$%^&*():',.");
                int lineCount = 0;
                int lineSum = 0;

                while (tokens.hasMoreTokens()) {
                    String token = tokens.nextToken();
                    try {
                        int number = Integer.parseInt(token);
                        lineCount++;
                        totalNumbers++;
                        lineSum += number;
                        if (number > 0) {
                            positiveCount++;
                        } else if (number < 0) {
                            negativeCount++;
                        } else {
                            zeroCount++;
                        }
                    } catch (NumberFormatException e) {
                        // Ignore non-integer tokens
                    }

                }

                double lineAverage = (double) lineSum / lineCount;
                System.out.printf("Line %d - Average: %.2f\n", lineNumber, lineAverage);
                lineNumber++;
            }
            System.out.printf("Statistics:\n");
            System.out.printf("Total numbers: %d\n", totalNumbers);
            System.out.printf("Positive numbers: %.2f%%\n", (double) positiveCount / totalNumbers * 100);
            System.out.printf("Negative numbers: %.2f%%\n", (double) negativeCount / totalNumbers * 100);
            System.out.printf("Zeroes: %.2f%%\n", (double) zeroCount / totalNumbers * 100);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Main entry point for the FileStats program.
     * Expects a single filename argument and invokes printFileStats.
     *
     * @param args command-line arguments: args[0] is expected to be the filename
     * @requires args.length == 1
     * @effect Validates arguments, opens the file, and prints statistics
     * @throws IOException if printFileStats fails due to I/O issues
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java FileStats <filename>");
            return;
        }

        String filename = args[0];
        FileReader in = new FileReader(filename);

        if (!(in.ready())) {
            System.out.println("File not found or empty.");
            return;
        }
        printFileStats(in);
    }

}