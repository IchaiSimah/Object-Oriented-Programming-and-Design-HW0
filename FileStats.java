import java.io.*;
import java.util.StringTokenizer;

public class FileStats {
    public static void printFileStats(FileReader in) throws IOException {

        // count number of numbers in the file

        int totalNumbers = 0;
        int totalSum = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        try (BufferedReader reader = new BufferedReader(in)) {
            int sign = 1;
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line, ";{}[]=+_!@#$%^&*():',.");
                int lineCount = 0;
                int lineSum = 0;

                while (tokens.hasMoreTokens()) {
                    String token = tokens.nextToken();
                    StringTokenizer negativeSpliterTokens = new StringTokenizer(token, "-");

                    while (negativeSpliterTokens.hasMoreTokens()) {
                        String insideToken = negativeSpliterTokens.nextToken();

                        if (insideToken == "") {
                            sign = -1;
                        } else {
                            try {
                                int number = sign * Integer.parseInt(insideToken);
                                lineCount++;
                                totalNumbers++;
                                lineSum += number;
                                totalSum += number;
                                if (number > 0) {
                                    positiveCount++;
                                } else if (number < 0) {
                                    negativeCount++;
                                } else {
                                    zeroCount++;
                                }
                                sign = 1;
                            } catch (NumberFormatException e) {
                                // Ignore non-integer tokens
                            }

                        }
                    }
                }

                double lineAverage = (double) lineSum / lineCount;
                System.out.printf("Line %d - Average: %.2f\n", lineNumber, lineAverage);
                lineNumber++;
            }
            System.out.println("Statistics:");
            System.out.println("Total numbers: " + totalNumbers);
            System.out.println("Positive numbers: " + positiveCount);
            System.out.println("Negative numbers: " + negativeCount);
            System.out.println("Zeroes: " + zeroCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

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