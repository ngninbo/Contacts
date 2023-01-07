package contacts;

import contacts.builder.PhoneBookBuilder;
import contacts.factory.Menu;

public class Main {

    public static void main(String[] args) {
        PhoneBookBuilder.init()
                .withMenu(new Menu())
                .build()
                .load(args[1])
                .processCommand();
    }
}
