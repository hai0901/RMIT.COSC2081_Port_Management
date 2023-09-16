package Interface;

import User.PortManager;
import User.PortManagerList;
import
import java.io.File;
import java.util.Scanner;

public class PortManagerInterface {
    protected final static File portManagerFile = new File("Assignment2_COSC2081/src/User/manager.txt");
    Scanner scanner = new Scanner(System.in);
    private PortManager currentportManager = new PortManager();
    private PortManagerList portManagerList = new PortManagerList();
    // create new port manager if not exist in list
    public void createNewPortManager() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter port: ");
        String port = scanner.nextLine();
        PortManager portManager = new PortManager(username, password, port);
        portManagerList.getPortManagersList().add(portManager);
        portManagerList.writeToFile();
    }

}
