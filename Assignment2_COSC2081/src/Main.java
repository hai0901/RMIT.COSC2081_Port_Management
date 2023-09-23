
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
        
        System.out.println("-------------------MAIN  MENU---------------------");
        MainMenu menu = new MainMenu(true);

        menu.display();


    }
}