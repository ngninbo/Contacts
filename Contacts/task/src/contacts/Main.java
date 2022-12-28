package contacts;

import contacts.factory.CommandFactory;

public class Main {

    public static void main(String[] args) {
        PhoneBookBuilder
                .init()
                .withCommandFactory(new CommandFactory())
                .build()
                .processCommand();
    }
}
