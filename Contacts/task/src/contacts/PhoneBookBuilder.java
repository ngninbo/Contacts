package contacts;

import contacts.factory.CommandFactory;

public class PhoneBookBuilder {
    private CommandFactory commandFactory;
    private String filename;

    private PhoneBookBuilder() {
    }

    public static PhoneBookBuilder init() {
        return new PhoneBookBuilder();
    }

    public PhoneBookBuilder withCommandFactory(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
        return this;
    }

    public PhoneBook build() {
        return new PhoneBook(commandFactory);
    }
}