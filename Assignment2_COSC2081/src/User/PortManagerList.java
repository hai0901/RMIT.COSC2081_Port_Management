package User;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class PortManagerList {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<PortManager> portManagersList = new ArrayList<>();
    protected final static File portManagerFile = new File("Assignment2_COSC2081/src/User/manager.txt");

    // get Manager File
    public static File getPortManagerFile() {
        return portManagerFile;
    }
    // Transfer data from file to ArrayList
    public void transferDataFromFileToArrayList() {
        ArrayList<String> portManagerList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(portManagerFile);
            while (scanner.hasNextLine()) {
                portManagerList.add(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
        for (String portManager : portManagerList) {
            String[] portManagerInfo = portManager.split(",");
            PortManager portManager1 = new PortManager(portManagerInfo[0], portManagerInfo[1], portManagerInfo[2]);
            portManagersList.add(portManager1);
        }
    }
    // display all port manager
    public void displayAllPortManager() {
        System.out.println("List of all port managers: ");
        for (PortManager portManager : portManagersList) {
            System.out.println(portManager);
        }
    }







    public PortManagerList(ArrayList<PortManager> portManagersList) {
        this.portManagersList = portManagersList;
    }

    public ArrayList<PortManager> getPortManagersList() {
        return portManagersList;
    }

    public void setPortManagersList(ArrayList<PortManager> portManagersList) {
        this.portManagersList = portManagersList;
    }
}
