package contacts;

import contacts.builder.PhoneBookBuilder;
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
