package FileHandling;

import User.PortManager;

import java.io.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.io.*;
import java.nio.file.*;



public class File {



    // Write to file
    public static void writeToFile(String fileName, String text, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
        writer.write(text);
        writer.newLine();
        writer.close();
    }

    public static void writeToFileAutoDelete(String fileName, String text, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
        writer.write(text);
        writer.newLine();
        writer.close();

        // Schedule line deletion after 1 minute
        scheduleLineDeletion(fileName, text, 1);
    }

    private static void scheduleLineDeletion(String fileName, String text, int minutesToKeep) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    removeLineFromFile(fileName, text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, minutesToKeep * 60 * 1000); // set timmer : 1 minute
    }

    private static void removeLineFromFile(String fileName, String lineToRemove) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        List<String> updatedLines = new ArrayList<>();
        boolean lineFound = false;

        for (String line : lines) {
            if (!line.equals(lineToRemove)) {
                updatedLines.add(line);
            } else {
                lineFound = true;
            }
        }

        if (lineFound) {
            // Write the updated lines back to the file
            Files.write(path, updatedLines, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }





    // Read from file
    public static void readFromFileAndCreateList(String fileName, ArrayList list) {

    }
    // Update new content to file
    public static void updateToFile(String fileName, ArrayList<PortManager> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        for (PortManager manager : list) {
            writer.write(manager.toString());
            writer.newLine();
        }
        writer.close();
    }


}
