package User;

import Port.*;
import Interface.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SystemAdmin extends User {
    private User admin;
    private Port port;

    public SystemAdmin(String username, String password, User admin, Port port) {
        super(username, password);
        this.admin = admin;
        this.port = port;
    }

    public static void login() {
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
