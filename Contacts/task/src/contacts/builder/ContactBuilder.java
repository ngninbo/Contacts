package contacts.builder;

import contacts.model.Contact;
import contacts.utils.InputValidator;
import contacts.utils.MessageResourcesBundle;

public abstract class ContactBuilder {

    protected MessageResourcesBundle resourcesBundle = MessageResourcesBundle.getInstance();

    public abstract void init();
    public abstract void setName();
    public abstract void setNumber();

    public abstract Contact create();

    public String validate(String number) {
        if (!InputValidator.isValidNumber(number)) {
            System.out.println(resourcesBundle.get("number.validation.error.msg"));
            number = resourcesBundle.get("missing.number.msg");
        }

        return number;
    }
}
