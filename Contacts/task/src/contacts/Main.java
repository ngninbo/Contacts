package contacts;

import contacts.builder.PhoneBookBuilder;
import contacts.factory.CommandFactory;

public class Main {

    public static void main(String[] args) {
        PhoneBookBuilder
                .init()
                .load(args[1])
                .withCommandFactory(new CommandFactory())
                .build()
                .processCommand();
    }
}
