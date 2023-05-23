package contacts.command;

public class ContactCountCommand extends Command {

    @Override
    public void execute() {
        print("phone.book.record.size.msg", contactList.count());
    }
}
