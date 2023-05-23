package contacts.command;

import contacts.core.ContactList;
import contacts.model.Contact;
import contacts.utils.InputValidator;
import contacts.utils.MessageResourcesBundle;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Command {

    protected ContactList contactList;

    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }

    public abstract void execute();

    public Command setContact(Contact contact) {
       return null;
    }

    public void list(List<Contact> contacts) {
        IntStream.range(0, contacts.size())
                .forEach(i -> print("item.format", i + 1, contacts.get(i).getFullName()));
    }

    public void updateItems(String action, List<Contact> contacts) {
        if (InputValidator.isValidAction().test(action, contacts.size())) {
            int number = Integer.parseInt(action) - 1;
            new ContactUpdateCommand(contacts.get(number)).execute();
        }
    }

    public String format(String messageKey, Object... vargs) {
        return MessageFormat.format(MessageResourcesBundle.getInstance().get(messageKey), vargs);
    }

    public String join(String... keys) {
        return Arrays.stream(keys).map(this::format).collect(Collectors.joining(", "));
    }

    public void print(String messageKey, Object... args) {
        System.out.println(format(messageKey, args));
    }
}
