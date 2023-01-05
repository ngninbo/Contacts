package contacts.domain;

import contacts.command.Command;
import contacts.factory.CommandFactory;
import contacts.utils.PhoneBookUtils;

public class PhoneBook {

    private final CommandFactory commandFactory;
    private String action;

    public PhoneBook(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void processCommand() {
        while (!"exit".equals(action)) {
            action = PhoneBookUtils.requestInput("[menu] Enter action (add, list, search, count, exit): ");
            Command command = commandFactory.getCommand(action);
            if (command != null) {
                command.execute();
            }
            System.out.println();
        }
    }
}
