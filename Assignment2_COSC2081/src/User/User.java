package User;

import java.util.Scanner;

public abstract class User {
    private static String username;
    private static String password;
    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
//    public abstract void Login();
//    public abstract void showMenu();
//    public abstract boolean validateLogin(String managerAccount);


    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
