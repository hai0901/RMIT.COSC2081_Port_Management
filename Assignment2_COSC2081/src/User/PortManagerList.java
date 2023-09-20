package User;
import FileHandling.*;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PortManagerList {
    protected ArrayList<PortManager> portManagersList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    protected static final File portManagerFile = new File("Assignment2_COSC2081/src/User/manager.txt");
    private int i;

    // get Manager File
    public static File getPortManagerFile() {
        return portManagerFile;
    }
    // get Port Manager List
    public ArrayList<PortManager> getPortManagersList() {
        return portManagersList;
    }
    // Create array list of port manager from file
    public void createPortManagerList() throws FileNotFoundException {
        String port, username, password;
        String line;

        Scanner scanner = new Scanner(portManagerFile);

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(line, ",");
            username = st.nextToken();
            password = st.nextToken();
            port = st.nextToken();
            PortManager portManager = new PortManager(username, password, port);
            portManagersList.add(portManager);
        }
        scanner.close();

    }


    // delete port manager by username
    public void deletePortManager() throws FileNotFoundException {
        PortManager result = null;
        System.out.println("Enter PortManager's portID: ");
        String port = scanner.next();

        for (PortManager pmanager : portManagersList) {
            if (pmanager.getPort().equalsIgnoreCase(port)) {
                result = pmanager;
                this.portManagersList.remove(pmanager);
                break;
            }
        }
        if (result != null) {
            System.out.println("Manager removed successfully!");
        }
        else
            System.out.println("No matching customer found!");
        FileHandling.File.updateToFile("portManagerFile", portManagersList);
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
