// You can experiment here, it won’t be checked

import java.io.*;

public class Task {
  public static void main(String[] args) {
    Container container = new Container("one", 1);
    String fileName = "container.data";

    try (FileInputStream fis = new FileInputStream(fileName);
         FileOutputStream fos = new FileOutputStream(fileName)) {

      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(container);

      BufferedInputStream bis = new BufferedInputStream(fis);
      ObjectInputStream ois = new ObjectInputStream(bis);
      Container obj = (Container) ois.readObject();

      System.out.println(obj.getName() + " " + obj.getValue());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}


class Container implements Serializable {
  private static final long serialVersionUID = 5L;

  private final transient String name;
  private final transient long value;

  Container(String name, long value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public long getValue() {
    return value;
  }
}