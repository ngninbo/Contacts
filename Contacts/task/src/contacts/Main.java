package contacts;

public class Main {

    public static void main(String[] args) {
        new PhoneBook()
                .load(args[1])
                .processCommand();
    }
}
