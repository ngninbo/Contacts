package contacts.factory;

import java.text.MessageFormat;

public class PatternFactory {

    private static final ResourcesBundleFactory PATTERN = ResourcesBundleFactory.from("pattern");

    public static String format(String patternKey, Object... args) {
        return MessageFormat.format(from(patternKey), args);
    }

    public static String from(String patternKey) {
        return PATTERN.get(patternKey);
    }
}
