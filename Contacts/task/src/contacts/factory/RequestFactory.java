package contacts.factory;

import contacts.domain.*;
import java.util.Scanner;
import java.util.stream.Stream;

import static contacts.factory.MessageFactory.*;

public class RequestFactory {

    private static final String FIELD_ENTER_MSG = "field.enter.msg";
    public static final String MENU_ACTION_SELECTION_MSG = "menu.action.selection.msg";
    public static final String FIELD_ENTER_MULTIPLE_MSG = "field.enter.multiple.msg";
    public static final String CONTACT_GENDER = "contact.gender";
    public static final String ORGANIZATION_NAME = "organization.name";
    public static final String ACTION_NUMBER = "action.number";
    public static final String ACTION_BACK = "action.back";
    public static final String CONTACT_TYPE = "contact.type";
    public static final String FIELD_SELECTION_MSG = "field.selection.msg";
    public static final String ENTER_SELECTED_MSG = "enter.selected.msg";
    public static final String RECORD_LABEL = "record.label";
    public static final String CONTACT_CREATION_BIRTH = "contact.creation.birth";

    public static String requestInput(String message) {
        System.out.print(message.concat(": "));
        return new Scanner(System.in).nextLine();
    }

    public static String requestListItemSelection() {
        return requestInput("\n".concat(format(MENU_ACTION_SELECTION_MSG, MenuAction.LIST.toLowerCase(),
                join(Stream.of(ACTION_NUMBER, ACTION_BACK)))));
    }

    public static String requestContactUpdateAction() {
        return requestInput("\n".concat(format(MENU_ACTION_SELECTION_MSG,
                format(RECORD_LABEL), join(ContactUpdateAction.getActions()))));
    }

    public static String requestMenuSelection() {
        return requestInput(format(MENU_ACTION_SELECTION_MSG, from(ContactUpdateAction.MENU.getLabel()), join(MenuAction.getActions())));
    }

    public static String requestField(String fields) {
        return requestInput(format(FIELD_SELECTION_MSG, fields));
    }

    public static String requestValue(ContactField field) {
        return requestInput(format(ENTER_SELECTED_MSG, format(field.getLabel()).toLowerCase()));
    }

    public static String requestContactType() {
        return requestInput(format(FIELD_ENTER_MULTIPLE_MSG, from(CONTACT_TYPE), ContactType.getValuesAsString()));
    }

    public static String request(ContactField field) {

        if (ContactField.GENDER.equals(field)) {
            return requestGenderInput();
        }

        return requestInput(formatFieldRequestMessage(field));
    }

    private static String requestGenderInput() {
        return requestInput(format(FIELD_ENTER_MULTIPLE_MSG, from(CONTACT_GENDER).toLowerCase(), Gender.joinGender()));
    }

    public static String requestBirthdateInput() {
        return requestInput(format(FIELD_ENTER_MSG, format(CONTACT_CREATION_BIRTH).toLowerCase()));
    }

    public static String requestOrganisationName() {
        return requestInput(format(FIELD_ENTER_MSG, format(ORGANIZATION_NAME).toLowerCase()));
    }

    private static String formatFieldRequestMessage(ContactField contactField) {
        return format(FIELD_ENTER_MSG, format(contactField.getLabel()).toLowerCase());
    }
}
