package contacts.builder;

import contacts.controller.ContactController;
import contacts.domain.PhoneBook;
import contacts.factory.CommandFactory;

public class PhoneBookBuilder {
    private CommandFactory commandFactory;

    private PhoneBookBuilder() {
    }

    public static PhoneBookBuilder init() {
        return new PhoneBookBuilder();
    }

    public PhoneBookBuilder load(String filename) {
        ContactController.getControllerInstance().load(filename);
        return this;
    }

    public PhoneBookBuilder withCommandFactory(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
        return this;
    }

    public PhoneBook build() {
        return new PhoneBook(commandFactory);
    }
}