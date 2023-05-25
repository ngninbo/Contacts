package contacts.command;

import contacts.model.Contact;

import static contacts.factory.RequestFactory.RECORD_DELETE_SUCCESS_MSG;

public class ContactDeleteCommand extends Command {

    private Contact contact;

    @Override
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void execute() {
        delete();
    }

    private void delete() {
        if (contactList.remove(contact)) {
            print(RECORD_DELETE_SUCCESS_MSG);
        }
    }
}
