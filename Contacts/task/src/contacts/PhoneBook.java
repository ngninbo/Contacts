package contacts;

import contacts.action.*;
import contacts.menu.PhoneBookMenuOption;

import java.util.Scanner;

public class PhoneBook {

    private boolean exit;
    private final PhoneBookMenuOption menuOption;

    {
        menuOption = new PhoneBookMenuOption();
    }

    public void processCommand() {
        while (!exit) {
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            switch (action) {
                case "add":
                    new ContactAddCommand(menuOption).execute();
                    break;
                case "remove":
                    new ContactRemoveCommand(menuOption).execute();
                    break;
                case "edit":
                    new ContactEditCommand(menuOption).execute();
                    break;
                case "count":
                    new ContactCountCommand(menuOption).execute();
                    break;
                case "list":
                    new ContactListCommand(menuOption).execute();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    // implement me
            }
        }
    }
}
