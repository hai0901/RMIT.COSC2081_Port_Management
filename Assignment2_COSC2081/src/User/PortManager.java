package User;

import java.util.Scanner;

public class PortManager extends User {
    Scanner scanner = new Scanner(System.in);
    private String port = null;


    public PortManager() {
    }
    public PortManager(String username, String password) {
        super(username, password);
        this.port = "0";
    }

    public PortManager(String username, String password, String port) {
        super(username, password);
        this.port = port;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return getUsername() + ',' + getPassword() + ',' + getPort();
    }

    // display interface
    public void displayPortManagerInterface() {
        System.out.println(this.port);
    }
}
