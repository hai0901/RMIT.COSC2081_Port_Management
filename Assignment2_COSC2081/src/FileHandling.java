import java.io.*;

import java.util.ArrayList;

import java.util.Scanner;


public class FileHandling {

    // Update a line in a text file
    public static void updateContent(String fileName, ArrayList list) {
        // Delete the old line of the file
        FileHandling.deleteContent(fileName);

        // Write new line to the file
        for (Object o : list) {
            FileHandling.writeToFile(fileName, o.toString());
        }

        // Delete object in the list
        list.clear();
    }

    // Delete a line in a text file
    public static void deleteContent(String fileName) {
        PrintWriter writer = null;
        // Create new product and add it to the text file

        try {
            writer = new PrintWriter(new FileWriter(fileName, false));
            writer.print("");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        if (writer != null)
            writer.close();
    }

    // Count line
    public static long countLines(String fileName) {
        int count = 0;
        Scanner fileScanner;
        // Get the file path
        try {
            fileScanner = new Scanner(new File(fileName));

            // Count the lines
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
                count++;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return count;
    }
    // Write to a text file
    public static void writeToFile(String fileName, String text) {
        PrintWriter writer = null;
        // Create new product and add it to the text file

        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
            writer.println(text);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        if (writer != null)
            writer.close();
    }
}
