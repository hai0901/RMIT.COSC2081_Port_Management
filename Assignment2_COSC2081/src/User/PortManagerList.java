package User;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PortManagerList {
    protected ArrayList<PortManager> portManagersList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    protected static final File portManagerFile = new File("Assignment2_COSC2081/src/DataSource/manager.txt");
    private int i;

    //get Manager File
    public static File getPortManagerFile() {
       return portManagerFile;
    }
    // get Port Manager List
    public ArrayList<PortManager> getPortManagersList() {
        return portManagersList;
    }
    // Create array list of port manager from file
    public void createPortManagerList() throws FileNotFoundException {
        Scanner scanner = new Scanner(getPortManagerFile());
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) {
                PortManager manager = new PortManager(parts[0], parts[1], parts[2]);
                portManagersList.add(manager);
            }
        }
        scanner.close();
    }





    // display port manager list
    public void displayPortManagerList() {
        for (PortManager pmanager : portManagersList) {
            System.out.println(pmanager);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        PortManagerList portManagerList = new PortManagerList();
        portManagerList.createPortManagerList();
        portManagerList.displayPortManagerList();

    }
}
