package contacts.utils;

import contacts.domain.ContactUpdateAction;
import contacts.domain.MenuAction;
import contacts.domain.Gender;

import java.text.MessageFormat;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneBookUtils {

    public static String requestInput(String message) {
        System.out.print(message.concat(": "));
        return new Scanner(System.in).nextLine();
    }

    public static String requestMenuSelection() {
        return requestInput(format("menu.action.selection.msg",
                format(ContactUpdateAction.MENU.getLabel()), join(MenuAction.getActions())));
    }

    public static String requestAddressInput() {
        return requestInput(format("field.enter.msg", format("contact.address").toLowerCase()));
    }

    public static String requestNumberInput() {
        return requestInput(format("field.enter.msg", format("contact.number").toLowerCase()));
    }

    public static String requestNameInput() {
        return requestInput(format("field.enter.msg", format("contact.name").toLowerCase()));
    }

    public static String requestSurnameInput() {
        return requestInput(format("field.enter.msg", format("contact.surname").toLowerCase()));
    }

    public static String requestBirthdateInput() {
        return requestInput(format("field.enter.msg", format("contact.creation.birth").toLowerCase()));
    }

    public static String requestGenderInput() {
        return requestInput(format("field.enter.multiple.msg",
                format("contact.gender").toLowerCase(), Gender.getValuesAsString()));
    }

    public static String requestOrganisationName() {
        return requestInput(format("field.enter.msg", format("organization.name").toLowerCase()));
    }

    public static String format(String messageKey, Object... params) {
        return MessageFormat.format(MessageResourcesBundle.getInstance().get(messageKey), params);
    }

    public static String join(Stream<String> keys) {
        return keys.map(PhoneBookUtils::format).collect(Collectors.joining(", "));
    }
}
