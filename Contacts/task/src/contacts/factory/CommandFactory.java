package contacts.factory;

import contacts.command.*;

public class CommandFactory {

    public Command getCommand(String action) {

        switch (action) {
            case "add":
                return new ContactAddCommand();
            case "list":
                return new ContactListCommand();
            case "search":
                return new ContactSearchCommand();
            case "count":
                return new ContactCountCommand();
            default:
        }

        return null;
    }
}
