package contacts.utils;

import contacts.domain.ContactUpdateAction;
import contacts.domain.MenuAction;
import contacts.domain.Gender;

import java.text.MessageFormat;
import java.util.Scanner;

public class PhoneBookUtils {

    public static String requestInput(String message) {
        System.out.print(message.concat(": "));
        return new Scanner(System.in).nextLine();
    }

    public static String requestMenuSelection() {
        return requestInput(getMessage("menu.action.selection.msg",
                ContactUpdateAction.MENU.name().toLowerCase(), MenuAction.getActions()));
    }

    public static String requestAddressInput() {
        return requestInput(getMessage("field.enter.msg", "address"));
    }

    public static String requestNumberInput() {
        return requestInput(getMessage("field.enter.msg", "number"));
    }

    public static String requestNameInput() {
        return requestInput(getMessage("field.enter.msg", "name"));
    }

    public static String requestSurnameInput() {
        return requestInput(getMessage("field.enter.msg", "surname"));
    }

    public static String requestBirthdateInput() {
        return requestInput(getMessage("field.enter.msg", "birth date"));
    }

    public static String requestGenderInput() {
        return requestInput(getMessage("field.enter.multiple.msg", "gender", Gender.getValuesAsString()));
    }

    public static String requestOrganisationName() {
        return requestInput(getMessage("field.enter.msg", "organization name"));
    }

    public static String getMessage(String key, Object... params) {
        return format(key, params);
    }

    public static String format(String messageKey, Object... params) {
        return MessageFormat.format(MessageResourcesBundle.getInstance().get(messageKey), params);
    }
}
