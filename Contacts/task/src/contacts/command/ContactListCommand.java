package contacts.command;

import contacts.domain.MenuAction;

import static contacts.factory.RequestFactory.CONTACT_LIST_EMPTY_MSG;
import static contacts.factory.RequestFactory.requestInput;

public class ContactListCommand extends Command {

    @Override
    public void execute() {
        list();
    }

    public void list() {

        if (contactList.isEmpty()) {
            print(CONTACT_LIST_EMPTY_MSG);
            return;
        }

        list(contactList);

        String action = requestInput(MenuAction.LIST);;

        updateItems(action, contactList);
    }
}
