package contacts.command;

import contacts.domain.MenuAction;
import contacts.factory.MessageFactory;
import contacts.factory.PatternFactory;
import contacts.model.Contact;

import java.util.List;

import static contacts.factory.RequestFactory.*;

public class ContactSearchCommand extends Command {

    @Override
    public void execute() {
        search();
    }

    public void search() {
        String query = requestSearchQuery();
        String regex = PatternFactory.format(SEARCH_QUERY, query);
        List<Contact> contactItems = contactList.search(regex);
        print(SEARCH_RESULT_MSG, contactItems.size());

        if (contactItems.isEmpty()) {
            return;
        }

        list(contactItems);
        String action = requestInput(MenuAction.SEARCH);

        if (MessageFactory.from(ACTION_AGAIN).equals(action)) {
            search();
        }

        updateItems(action, contactItems);
    }
}
