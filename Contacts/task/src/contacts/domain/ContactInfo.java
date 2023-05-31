package contacts.domain;

import contacts.model.Contact;

import java.util.*;
import java.util.stream.Collectors;
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
        toMap(getFieldLabels(), getValues()).forEach(this::print);
    }

    protected Map<String, String> toMap(List<String> fields, String... values) {

        if (fields.size() != values.length) {
            return Map.of();
        }

        Map<String, String> fieldInfos = IntStream.range(0, fields.size()).boxed()
                .collect(Collectors.toMap(fields::get, i -> values[i], (a, b) -> b, LinkedHashMap::new));

        fieldInfos.putAll(Map.of(
                CONTACT_CREATION_TIME, contact.getCreatedTime().toString(),
                CONTACT_LAST_EDIT, contact.getLastEditTime().toString()));

        return fieldInfos;
    }

    protected void print(String field, String value) {
        System.out.println(format(FIELD_INFO, from(field), value));
    }

    protected abstract String[] getValues();
}
