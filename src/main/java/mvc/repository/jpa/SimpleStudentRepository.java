package mvc.repository.jpa;

import mvc.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleStudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.name = :name")                // JPQL
    Student getStudentByName(String name);
}



//  interface extends interface     OK

//  class implements interface      OK
//  class extends class             Ok

//  interface implements interface  NOT OK
//  class extends interface         NOT OK
//  class implements class          NOT OK

