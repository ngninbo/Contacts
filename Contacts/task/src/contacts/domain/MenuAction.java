package contacts.domain;

public enum MenuAction {

    ADD,
    LIST,
    SEARCH,
    COUNT,
    EXIT,
    EDIT,
    DELETE,
    MENU,
    VIEW_RECORD,
    BACK,
    AGAIN,
    NO_ACTION;

    public static final String ACTION_NUMBER = "action.number";

    public String toLowerCase() {
        return name().toLowerCase();
    }

    public String getLabel() {
        return "action.".concat(toLowerCase().replace("_", "."));
    }
}
