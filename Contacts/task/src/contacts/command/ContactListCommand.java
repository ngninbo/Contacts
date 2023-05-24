package contacts.command;

import static contacts.factory.RequestFactory.requestListItemSelection;

public class ContactListCommand extends Command {

    @Override
    public void execute() {
        list();
    }

    public void list() {

        if (contactList.isEmpty()) {
            print("contactList.empty.msg");
            return;
        }

        list(contactList);

        String action = requestListItemSelection();

        updateItems(action, contactList);
    }
}
