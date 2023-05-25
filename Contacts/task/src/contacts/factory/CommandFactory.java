package contacts.factory;

import contacts.command.*;
import contacts.domain.MenuAction;

import java.util.Optional;

public class CommandFactory {

    public static Optional<Command> of(MenuAction action) {
        return Optional.ofNullable(commandOf(action));
    }

    private static Command commandOf(MenuAction action) {
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
            case EDIT:
                return new ContactEditCommand();
            case DELETE:
                return new ContactDeleteCommand();
            default:
                return null;
        }
    }
}
