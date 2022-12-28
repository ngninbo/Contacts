package contacts.command;

import contacts.controller.ContactController;

public class ContactListCommand implements Command {

    @Override
    public void execute() {
        ContactController.getControllerInstance().list();
    }
}
