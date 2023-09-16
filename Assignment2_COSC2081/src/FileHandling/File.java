package FileHandling;

import java.io.*;

public class File {
    private String fileName;

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
    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    // Delete from file
    public static void deleteFromFile(String fileName, String text) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(text)) {
                    System.out.println("Deleted!");
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    // Update new content to file
    public static void updateToFile(String fileName, String oldText, String newText) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(oldText)) {
                    System.out.println("Updated!");
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
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
