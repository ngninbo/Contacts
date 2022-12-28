package contacts.command;

import contacts.controller.ContactController;
import contacts.domain.Contact;

import static contacts.utils.PhoneBookUtils.requestInput;

public class ContactEditCommand implements Command {

    private final Contact contact;

    public ContactEditCommand(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void execute() {
        edit();
    }

    private void edit() {

        String field = requestInput(String.format("Select a field (%s): ", contact.getEditableFields()));
        if (!field.isEmpty()) {
            String value = requestInput(String.format("Enter %s: ", field));
            contact.setFieldValue(field, value);
            ContactController.getControllerInstance().update(contact);
            System.out.println("Saved");
            contact.info();
        }
    }
}
