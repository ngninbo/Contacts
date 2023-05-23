package contacts.factory;

import contacts.command.*;
import contacts.domain.ContactUpdateAction;
import contacts.domain.MenuAction;

public class CommandFactory {

    public static Command commandOf(MenuAction action) {
        switch (action) {
            case ADD:
                return new ContactAddCommand();
            case LIST:
                return new ContactListCommand();
            case SEARCH:
                return new ContactSearchCommand();
            case COUNT:
                return new ContactCountCommand();
            case EXIT:
                return new PhoneBookExitCommand();
            default:
                return null;
        }
    }

    public static Command commandOf(ContactUpdateAction action) {
        switch (action) {
            case EDIT:
                return new ContactEditCommand();
            case DELETE:
                return new ContactDeleteCommand();
            default:
                return null;
        }
    }
}
