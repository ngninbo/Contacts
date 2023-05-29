package contacts.domain;

import contacts.model.Contact;
import java.util.List;
import java.util.stream.IntStream;

import static contacts.factory.MessageFactory.format;
import static contacts.factory.MessageFactory.from;
import static contacts.factory.RequestFactory.*;

public abstract class ContactInfo {

    protected abstract List<String> getFieldLabels();
    protected Contact contact;

    public ContactInfo(Contact contact) {
        this.contact = contact;
    }

    public void showInfo() {
        print(getFieldLabels(), getValues());
    }

    protected void print(List<String> fields, String... values) {
        IntStream.range(0, fields.size()).forEach(i -> print(fields.get(i), values[i]));
        System.out.println(format(FIELD_INFO, from(CONTACT_CREATION_TIME), contact.getCreatedTime()));
        System.out.println(format(FIELD_INFO, from(CONTACT_LAST_EDIT), contact.getLastEditTime()));

    }

    protected void print(String field, String value) {
        System.out.println(format(FIELD_INFO, from(field), value));
    }

    protected abstract String[] getValues();
}
