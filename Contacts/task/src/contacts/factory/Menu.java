package contacts.factory;

import contacts.command.*;

public class Menu {

    private Command command;

    public void setCommand(String action) {

        switch (action) {
            case "add":
                command = new ContactAddCommand();
                break;
            case "list":
                command = new ContactListCommand();
                break;
            case "search":
                command = new ContactSearchCommand();
                break;
            case "count":
                command = new ContactCountCommand();
                break;
            case "exit":
                command = new ExitCommand();
            default:
        }
    }

    public void execute() {
        if (command != null) {
            command.execute();
        }
    }
}
