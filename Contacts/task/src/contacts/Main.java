package contacts;

import contacts.core.ContactList;

public class Main {

    public static void main(String[] args) {
        PhoneBook.of(ContactList.from(args[1])).processCommand();
    }
}
