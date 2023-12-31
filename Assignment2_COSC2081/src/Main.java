
import FileHandling.LoadDataBase;
import Interface.MainMenu;

import java.util.Scanner;
import Interface.*;
import User.*;
import Port.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // Display welcome screen
        LoadDataBase.createAll();
        System.out.println("COSC2081 GROUP ASSIGNMENT");
        System.out.println("PORT MANAGEMENT MANAGEMENT SYSTEM");
        System.out.println("Instructor: Mr. Minh Vu & Dr. Phong Ngo");
        System.out.println("Group: KMPH");
        System.out.println("s3975831, Ngo Quang Khai");
        System.out.println("s3979628, Cao Le Hoang Minh");
        System.out.println("s3963893, Dang Truong Phat");
        System.out.println("s3979239, Nguyen Pham Tien Hai");
        System.out.println("-------------------MAIN  MENU---------------------");
        MainMenu menu = new MainMenu(true);

        menu.display();


    }
}