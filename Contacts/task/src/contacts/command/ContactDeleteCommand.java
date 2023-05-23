package contacts.command;

import contacts.model.Contact;

public class ContactDeleteCommand extends Command {

    private Contact contact;

    @Override
    public Command setContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    @Override
    public void execute() {
        delete();
    }

    private void delete() {
        boolean deletionSucceed = contactList.remove(contact);
        if (deletionSucceed) {
            print("record.delete.success.msg");
        }
    }
}
