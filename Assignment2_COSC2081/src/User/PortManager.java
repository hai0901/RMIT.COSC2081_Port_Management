package User;

import java.util.Scanner;

public class PortManager extends User {
    Scanner scanner = new Scanner(System.in);
    private String port;

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


}
/*    public static boolean validateLogin(String managerAccount) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Assignment2_COSC2081/src/User/manager_login_credential.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(managerAccount)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static void Login() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("----------------MANAGER LOGIN PAGE----------------");
            if (validateLogin(User.displayLogin())) {
                System.out.println("Login successful!");
                System.out.println("--------------------------------------------------");
                isRunning = false;

            } else {
                System.out.println("Login failed!");
                System.out.println("Please try again!");
            }
        }
    }

    public static void showMenu() {
        String action;
        byte actionNum;
        boolean isRunning = true;
        System.out.println("-------------------MANAGER MENU-------------------");
        while (isRunning) {
            System.out.println("1. View total gallons of fuel used");
            System.out.println("2. View weight of containers");
            System.out.println("3. View ships");
            System.out.println("4. View trips");
            System.out.println("5. Exit Manager Menu");
            System.out.println("--------------------------------------------------");
            System.out.println("Enter your action: ");
            Scanner sc = new Scanner(System.in);
            action = sc.nextLine();
            try {
                actionNum = Byte.parseByte(action);
                switch (actionNum) {
                    case 1 -> System.out.println("View Managers");
                    case 2 -> System.out.println("Update Manager");
                    case 3 -> System.out.println("Delete Manager");
                    case 4 -> System.out.println("View Manager");
                    case 5 -> {
                        System.out.println("Exit Manager Menu");
                        isRunning = false;
                    }
                    default -> System.out.println("Invalid Action!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
}
*/