package contacts.command;

public class PhoneBookExitCommand extends Command {

    @Override
    public void execute() {
        contactList.save();
    }
}
