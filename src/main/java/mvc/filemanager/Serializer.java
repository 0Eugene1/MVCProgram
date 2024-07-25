package mvc.filemanager;

import java.io.*;

public class Serializer {

    public static void serialize(Object object) {

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.ser"));

            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object deserialize(String fileName) {        // todo
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("stedent.ser"));
            objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }return deserialize(fileName);
    }
}
