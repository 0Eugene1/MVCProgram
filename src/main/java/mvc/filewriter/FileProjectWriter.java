package mvc.filewriter;

import mvc.entities.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileProjectWriter {

    public static void fileWriter(Student student) {
        try ( FileWriter fw = new FileWriter("student.txt");
              BufferedWriter bf = new BufferedWriter(fw)){

            bf.write(student.getName());
            bf.newLine();
            bf.write(String.valueOf(student.getAge()));
            bf.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
