package contacts.command;

import contacts.domain.MenuAction;
import contacts.model.Contact;

import java.util.List;

import static contacts.utils.PhoneBookUtils.requestInput;

public class ContactSearchCommand extends Command {

    private final String again = format("search.again");

    @Override
    public void execute() {
        search();
    }

    public void search() {
        String query = requestInput(format("enter.search.query.msg"));
        List<Contact> contactItems = contactList.search(query);
        print("search.result.msg", contactItems.size());

        if (contactItems.isEmpty()) {
            return;
        }

        list(contactItems);
        String action = requestInput("\n".concat(format("menu.action.selection.msg",
                MenuAction.SEARCH.name().toLowerCase(), join("list.number", "list.back", "search.again"))));

        if (again.equals(action)) {
            search();
        }

        updateItems(action, contactItems);
    }
}
