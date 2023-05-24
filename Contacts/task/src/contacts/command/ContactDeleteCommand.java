package contacts.command;

import contacts.model.Contact;

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
            print("record.delete.success.msg");
        }
    }
}
