package contacts.builder;

import contacts.PhoneBook;
import contacts.factory.Menu;

public class PhoneBookBuilder {

    private Menu menu;

    private PhoneBookBuilder() {
    }

    public static PhoneBookBuilder init() {
        return new PhoneBookBuilder();
    }

    public PhoneBookBuilder withMenu(Menu menu) {
        this.menu = menu;
        return this;
    }

    public PhoneBook build() {
        return new PhoneBook(menu);
    }
}