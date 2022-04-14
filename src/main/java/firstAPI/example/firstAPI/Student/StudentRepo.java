package firstAPI.example.firstAPI.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
This interface is responsible for data access.
Generic types given to the JpaRepository are the type of the data we are working with,
and the type of the primary key which is 'id' in this case.
 */
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    //An optional will translate into sql. In this case it will find the student with the given email
//    The other option is to annotate with the @query() and pass the jpql instruction inside, both are equivalent
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
