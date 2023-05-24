package contacts.command;

import contacts.model.Contact;
import contacts.domain.ContactField;
import contacts.utils.InputValidator;

import static contacts.factory.RequestFactory.*;

public class ContactEditCommand extends Command {

    private Contact contact;

    @Override
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void execute() {
        edit();
    }

    public void edit() {
        final String input = requestField(join(contact.getEditableFields()));

        try {
            ContactField field = ContactField.valueOf(input.toUpperCase());

            String value = requestValue(field);
            if (isValidationRequired(field)) {
                value = InputValidator.validate(field, value);
            }

            contact.setFieldValue(field, value);
            contactList.update(contact);
            print("record.save.msg");
            contact.info();
        } catch (IllegalArgumentException e) {
            print("field.incorrect.msg", input);
        }
    }

    private boolean isValidationRequired(ContactField field) {
        return ContactField.getFieldsToBeValidated().contains(field);
    }
}
