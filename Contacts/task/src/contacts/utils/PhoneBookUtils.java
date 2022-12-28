package contacts.utils;

import contacts.domain.Contact;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PhoneBookUtils {

    public static String requestInput(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextLine();
    }

    public static void list(List<Contact> contacts) {
        IntStream.range(0, contacts.size())
                .forEach(i -> System.out.printf("%s. %s\n", i + 1, contacts.get(i).getFullName()));
    }
}
