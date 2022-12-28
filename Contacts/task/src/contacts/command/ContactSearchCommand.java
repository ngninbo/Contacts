package contacts.command;

import contacts.controller.ContactController;

public class ContactSearchCommand implements Command {

    @Override
    public void execute() {
        ContactController.getControllerInstance().search();
    }
}
