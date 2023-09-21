package FileHandling;

import java.io.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.*;

public class File {



    // Write to file
    public static void writeToFile(String fileName, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    // Read from file
    public static void readFromFileAndCreateList(String fileName, ArrayList list) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    // Delete from file
    public static void deleteFromFile(String fileName) {
        PrintWriter write = null;
        try {
            write = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (write != null) {
            write.print("");
            write.close();
        }
    }
    // Update new content to file
    public static void updateToFile(String fileName, ArrayList list) {
        File.deleteFromFile(fileName);
        for (Object o : list) {
            File.writeToFile(fileName, o.toString());
        }
        list.clear();
    }

    // Check if content exists in file
    public static boolean checkContent(String fileName, String text) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(text)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    // add to file
    public static void addToFile(String fileName, String text) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(text)) {
                    System.out.println("Added!");
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
