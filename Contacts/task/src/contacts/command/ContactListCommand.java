package contacts.command;

import contacts.domain.MenuAction;

import static contacts.utils.PhoneBookUtils.requestInput;

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

        String action = requestInput("\n".concat(format("menu.action.selection.msg",
                MenuAction.LIST.toLowerCase(), join("list.number", "list.back"))));

        updateItems(action, contactList);
    }
}
