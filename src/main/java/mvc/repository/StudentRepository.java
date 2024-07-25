package mvc.repository;

import mvc.connectionmanager.ConnectionManager;
import mvc.entities.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

@Repository
public class StudentRepository {

    private Connection connection;

    public StudentRepository() {
        connection = ConnectionManager.getConnection();
    }

//    private Map<Student, Integer> studentGrades;

//    public StudentRepository() {
//        studentGrades = new HashMap<>();
//        studentGrades.put(new Student("Andrey",25), 4);
//        System.out.println(studentGrades);

//    }
    public List<Student> allStudents() {            //  CRUD    -      CREATE READ UPDATE DELETE
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM students;");
            ResultSet resultSet = preparedStatement.executeQuery();
//
            List<Student> students = new ArrayList<>();
            while(resultSet.next()) {

                students.add(new Student(resultSet.getString("name"), resultSet.getInt("age")));

//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                Student student = new Student(name,age);
//                students.add(student);
            }

//            students.add(new Student("Ivan", 20));
//            students.add(new Student("Feodor",21));

            return students;

            //       name       age
            //       Ivan       20
            //       Feodor     21
            //       Petr       20
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        return studentGrades.toString();
    }

    public void addStudent(Student student) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO students VALUES (?,?);");
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//
//    public String gradeByStudent(Student student) {
//
//
//        Integer grade = studentGrades.get(student);
//
//        return grade.toString();
//
//
//
//
////      Student student = studentGrades.get("Alex");
////      String studentName = student.getName();
////
////        return studentName;
//    }

}
