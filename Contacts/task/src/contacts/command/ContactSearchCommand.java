package contacts.command;

import contacts.domain.MenuAction;
import contacts.model.Contact;

import java.util.List;
import java.util.stream.Stream;

import static contacts.factory.RequestFactory.requestInput;

public class ContactSearchCommand extends Command {

    private final String again = format("action.again");

    @Override
    public void execute() {
        search();
    }

    public void search() {
        String query = requestInput(format("enter.search.query.msg"));
        String regex = format("search.query", query);
        List<Contact> contactItems = contactList.search(regex);
        print("search.result.msg", contactItems.size());

        if (contactItems.isEmpty()) {
            return;
        }

        list(contactItems);
        String action = requestInput("\n".concat(format("menu.action.selection.msg",
                MenuAction.SEARCH.name().toLowerCase(), join(Stream.of("action.number", "action.back", "action.again")))));

        if (again.equals(action)) {
            search();
        }

        updateItems(action, contactItems);
    }
}
