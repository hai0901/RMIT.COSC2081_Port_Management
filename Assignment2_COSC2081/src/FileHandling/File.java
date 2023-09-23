package FileHandling;

import User.PortManager;

import java.io.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.*;

public class File {



    // Write to file
    public static void writeToFile(String fileName, String text, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
        writer.write(text);
        writer.newLine();
        writer.close();
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
