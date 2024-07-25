package mvc.controller;

import mvc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import mvc.service.StudentService;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {


                        //      client (postman) --> 8080 --> MVCProgram --> 3306 --> mysql server --> mydatabase

    @Autowired          //         Spring creates new studentService from the Spring context (Spring memory) and injects it into this studentService variable
    private StudentService studentService;

    @GetMapping("students")
    public List<Student> allStudents() {
        return studentService.allStudents();
    }

    @GetMapping("newStudent")
    public void addStudent(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age) {
        Student student = new Student(name, age);
        studentService.addStudent(student);
    }

//    @PostMapping("newStudent")
//    public void addStudent(@RequestBody Student student, @RequestParam(name = "grade") int grade) {
//        studentService.addStudent(student, grade);
//    }


//    @GetMapping("getGrade")
//    public String gradeByStudent(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age) {
//        Student student = new Student(name, age);
//        return studentService.gradeByStudent(student);
//    }

//    @PostMapping("getGrade")
//    public String studentGrade(@RequestBody Student student) {
//        return studentService.gradeByStudent(student);
//    }


}
