package contacts.command;

import contacts.core.ContactList;
import contacts.model.Contact;
import contacts.utils.InputValidator;
import contacts.utils.PhoneBookUtils;

import java.util.List;
import java.util.stream.Stream;

public abstract class Command {

    protected ContactList contactList;

    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }

    public abstract void execute();

    public void setContact(Contact contact) {}

    public void list(List<Contact> contacts) {
        System.out.println(PhoneBookUtils.format(contacts));
    }

    public void updateItems(String action, List<Contact> contacts) {
        if (InputValidator.isValidAction().test(action, contacts.size())) {
            int number = Integer.parseInt(action) - 1;
            Command command = new ContactUpdateCommand(contacts.get(number));
            command.setContactList(contactList);
            command.execute();
        }
    }

    public String format(String messageKey, Object... vargs) {
        return PhoneBookUtils.format(messageKey, vargs);
    }

    public String join(Stream<String> keys) {
        return PhoneBookUtils.join(keys).toLowerCase();
    }

    public void print(String messageKey, Object... args) {
        System.out.println(format(messageKey, args));
    }
}
