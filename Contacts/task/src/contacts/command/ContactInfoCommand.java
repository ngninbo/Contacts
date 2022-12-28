package contacts.command;

import contacts.controller.ContactController;

public class ContactInfoCommand implements Command {

    @Override
    public void execute() {
        ContactController.getControllerInstance().info();
    }
}
