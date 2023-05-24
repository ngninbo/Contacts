package contacts.factory;

import contacts.model.Contact;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MessageFactory {

    private static final ResourcesBundleFactory MESSAGES = ResourcesBundleFactory.from("messages");

    public static String format(String messageKey, Object... params) {
        return MessageFormat.format(from(messageKey), params);
    }

    public static String from(String messageKey) {
        return MESSAGES.get(messageKey);
    }

    public static String join(Stream<String> keys) {
        return join(keys,", ");
    }

    public static String join(Stream<String> keys, String delimiter) {
        return keys.map(MessageFactory::from).collect(Collectors.joining(delimiter));
    }

    public static String format(List<Contact> contactList) {
        return IntStream.range(0, contactList.size())
                .mapToObj(i -> format("item.format", i + 1, contactList.get(i).getFullName()))
                .collect(Collectors.joining("\n"));
    }
}
