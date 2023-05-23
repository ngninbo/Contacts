package contacts.utils;

import java.util.ResourceBundle;

public class MessageResourcesBundle {

    private static final MessageResourcesBundle INSTANCE = new MessageResourcesBundle();


    private ResourceBundle resourceBundle;

    {
        this.resourceBundle = ResourceBundle.getBundle("messages");
    }

    private MessageResourcesBundle() {

    }

    public MessageResourcesBundle(String baseName) {
        this.resourceBundle = ResourceBundle.getBundle(baseName);
    }

    public static MessageResourcesBundle getInstance() {
        return INSTANCE;
    }

    public static MessageResourcesBundle getInstance(String baseName) {
        return new MessageResourcesBundle(baseName);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
