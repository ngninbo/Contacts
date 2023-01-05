package contacts.command;

import contacts.controller.ContactController;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        ContactController.getControllerInstance().save();
    }
}
