package contacts.command;

import static contacts.factory.RequestFactory.PHONE_BOOK_RECORD_SIZE_MSG;

public class ContactCountCommand extends Command {

    @Override
    public void execute() {
        print(PHONE_BOOK_RECORD_SIZE_MSG, contactList.count());
    }
}
