package contacts.command;

import contacts.model.Contact;
import contacts.domain.ContactField;

import static contacts.utils.PhoneBookUtils.requestInput;

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
        final String input = requestInput(format("field.selection.msg", join(contact.getEditableFields())));

        try {
            ContactField field = ContactField.valueOf(input.toUpperCase());

            String value = requestInput(format("enter.selected.msg", format(field.getLabel())));
            contact.setFieldValue(field, value);
            contactList.update(contact);
            print("record.save.msg");
            contact.info();
        } catch (IllegalArgumentException e) {
            print("field.incorrect.msg", input);
        }
    }
}
