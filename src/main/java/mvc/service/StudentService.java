package mvc.service;

import mvc.entities.Student;
import mvc.repository.jpa.SimpleStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import mvc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired                                    ///     TODO Autowire mvc.service to mvc.repository, same as in mvc.controller
    private StudentRepository studentRepository;


    public List<Student> allStudents() {
        return studentRepository.allStudents();
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }
//    public String gradeByStudent(Student student) {
//       return studentRepository.gradeByStudent(student);
//    }





    @Autowired                                    ///     TODO Autowire mvc.service to mvc.repository, same as in mvc.controller
    private SimpleStudentRepository simpleStudentRepository;


    public void jpaAddStudent(Student student) {
        simpleStudentRepository.save(student);
    }

    public Student getStudentByName(String name) {
        return simpleStudentRepository.getStudentByName(name);
    }
}
