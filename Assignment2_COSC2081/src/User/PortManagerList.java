package User;
import FileHandling.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PortManagerList {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<PortManager> portManagersList = new ArrayList<>();
    private static final java.io.File portManagerFile = new java.io.File("Assignment2_COSC2081/src/User/manager.txt");
    // get Manager File
    public static java.io.File getPortManagerFile() {
        return portManagerFile;
    }
    // Transfer data from file to ArrayList
    public void fromFileToList() throws FileNotFoundException {
        String username, password, port;

        String line;

        Scanner fileScanner = new Scanner(portManagerFile);

        while (fileScanner.hasNext()) {
            line = fileScanner.nextLine();
            StringTokenizer reader = new StringTokenizer(line, ",");
            username = reader.nextToken();
            password = reader.nextToken();
            port = reader.nextToken();
            portManagersList.add(new PortManager( username, password, port ));
        }

        fileScanner.close();
    }
    // display all port manager
    public void displayAllPortManager() {
        System.out.println("List of all port managers: ");
        for (PortManager portManager : portManagersList) {
            System.out.println(portManager);
        }
    }







    public PortManagerList() {
        this.portManagersList = portManagersList;
    }

    public ArrayList<PortManager> getPortManagersList() {
        return portManagersList;
    }

    public void setPortManagersList(ArrayList<PortManager> portManagersList) {
        this.portManagersList = portManagersList;
    }

    public void writeToFile() {
        for (PortManager portManager : portManagersList) {
            File.writeToFile("portManagerFile", portManager.toString());
        }
    }
}
