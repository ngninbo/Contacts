package contacts.factory;

import java.util.ResourceBundle;

public class ResourcesBundleFactory {

    private final ResourceBundle resourceBundle;

    private ResourcesBundleFactory(String baseName) {
        this.resourceBundle = ResourceBundle.getBundle(baseName);
    }

    public static ResourcesBundleFactory from(String baseName) {
        return new ResourcesBundleFactory(baseName);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
