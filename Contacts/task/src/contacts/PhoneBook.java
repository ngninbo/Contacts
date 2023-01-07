package contacts;

import contacts.controller.ContactController;
import contacts.factory.Menu;
import contacts.utils.PhoneBookUtils;

public class PhoneBook {

    private String action;
    private final Menu menu;

    public PhoneBook(Menu menu) {
        this.menu = menu;
    }

    public void processCommand() {
        while (!"exit".equals(action)) {
            action = PhoneBookUtils.requestInput("[menu] Enter action (add, list, search, count, exit): ");
            menu.setCommand(action);
            menu.execute();
            System.out.println();
        }
    }

    public PhoneBook load(String filename) {
        ContactController.getControllerInstance().load(filename);
        return this;
    }
}
