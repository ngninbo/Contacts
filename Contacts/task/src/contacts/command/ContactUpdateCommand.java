package contacts.command;

import contacts.domain.MenuAction;
import contacts.domain.UpdateMenu;
import contacts.factory.CommandFactory;
import contacts.model.Contact;

import static contacts.factory.RequestFactory.requestInput;

public class ContactUpdateCommand extends Command {

    private final Contact contact;

    private MenuAction action = MenuAction.NO_ACTION;

    public ContactUpdateCommand(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void execute() {
        contact.info();

        while (process(action)) {
            action = new UpdateMenu().getAction(requestInput(MenuAction.VIEW_RECORD));
            CommandFactory.of(action).ifPresent(this::execute);
        }
    }

    private void execute(Command command) {
        command.setContactList(contactList);
        command.setContact(contact);
        command.execute();
    }

    private boolean process(MenuAction action) {
        return !MenuAction.MENU.equals(action);
    }
}
