package contacts.utils;

import contacts.model.Contact;

import java.io.*;

public class SerializationUtils {

    /**
     * Serialize the given object to the file
     */
    public static void serialize(Contact[] contacts, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(contacts);
        oos.close();
    }

    /**
     * Deserialize to an object from the file
     */
    public static Contact[] deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Contact[] obj = (Contact[]) ois.readObject();
        ois.close();
        return obj;
    }
}
