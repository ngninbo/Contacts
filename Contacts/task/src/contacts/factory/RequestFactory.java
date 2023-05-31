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
    public static final String CONTACT_TYPE = "contact.type";
    public static final String FIELD_SELECTION_MSG = "field.selection.msg";
    public static final String ENTER_SELECTED_MSG = "enter.selected.msg";
    public static final String CONTACT_CREATION_BIRTH = "contact.creation.birth";
    public static final String ENTER_SEARCH_QUERY_MSG = "enter.search.query.msg";
    public static final String ACTION_AGAIN = "action.again";
    public static final String SEARCH_QUERY = "search.query";
    public static final String SEARCH_RESULT_MSG = "search.result.msg";
    public static final String CONTACT_LIST_EMPTY_MSG = "contactList.empty.msg";
    public static final String RECORD_SAVE_MSG = "record.save.msg";
    public static final String FIELD_INCORRECT_MSG = "field.incorrect.msg";
    public static final String RECORD_DELETE_SUCCESS_MSG = "record.delete.success.msg";
    public static final String PHONE_BOOK_RECORD_SIZE_MSG = "phone.book.record.size.msg";
    public static final String RECORD_ADD_SUCCESS_MSG = "record.add.success.msg";
    public static final String CONTACT_TYPE_UNKNOWN = "contact.type.unknown";
    public static final String FIELD_INFO = "field.info";
    public static final String CONTACT_CREATION_TIME = "contact.creation.time";
    public static final String CONTACT_LAST_EDIT = "contact.last.edit";

    public static String requestInput(String message) {
        System.out.print(message.concat(": "));
        return new Scanner(System.in).nextLine();
    }

    public static String request(MenuAction menuAction, Stream<String> options) {
        return requestInput("\n".concat(format(MENU_ACTION_SELECTION_MSG, from(menuAction.getLabel()), join(options))));
    }

    public static String requestInput(MenuAction action) {
        return request(action, MenuFactory.of(action).map(Menu::getItems).orElse(Stream.of()));
    }

    public static String requestField(String fields) {
        return requestInput(format(FIELD_SELECTION_MSG, fields));
    }

    public static String requestValue(ContactField field) {
        return requestInput(format(ENTER_SELECTED_MSG, from(field.getLabel()).toLowerCase()));
    }

    public static String requestContactType() {
        return requestInput(format(FIELD_ENTER_MULTIPLE_MSG, from(CONTACT_TYPE), join(ContactType.getValues()).toLowerCase()));
    }

    public static String requestSearchQuery() {
        return requestInput(from(ENTER_SEARCH_QUERY_MSG));
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
