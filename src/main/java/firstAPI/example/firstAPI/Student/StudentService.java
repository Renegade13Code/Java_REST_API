package firstAPI.example.firstAPI.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;
/*
The component/service decorator is used to tell spring that this class will be injected into other classes
 */
//@Component
@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents(){
//        List<Student> list = new ArrayList<Student>();
//        list.add(new Student(1L,
//                "Jeff",
//                "jeff@gmail.com",
//                LocalDate.of(1996, 9, 20)));
//        list.add(new Student(2L,
//                "Bill",
//                "bill@gmail.com",
//                LocalDate.of(1994, 8, 6)));
//        return list;
        return studentRepo.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(student.toString());
        Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
//        studentRepo.save(studentOptional.get());
        studentRepo.save(student);
    }


    public void deleteStudent(Student student) {

        Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());
        if(studentOptional.isEmpty()){
            throw new IllegalStateException("Specified student does not exist");
        }
//        Note you have to use studentOptional.get() here as hibernate uses student.id to delete an entry.
        studentRepo.delete(studentOptional.get());
    }

/*
    //This was lecturers implementation
    public void deleteStudent(Long studentId) {
        if(!studentRepo.existsById(studentId)){
            throw new IllegalStateException("Specified student ID does not exist");
        }
        studentRepo.deleteById(studentId);
    }
*/

//    public void updateStudent(Student oldStudent, Student newStudent) {
//        Optional<Student> oldStudentOptional = studentRepo.findStudentByEmail(oldStudent.getEmail());
//        if(oldStudentOptional.isEmpty()){
//            throw new IllegalStateException("Specified student does not exist");
//        }
//        studentRepo.delete(oldStudentOptional.get());
//        studentRepo.save(newStudent);
//    }

//    @Transactional
//    public void updateStudent(Long id, Student updatedStudent){
//        Optional<Student> studentOptional = studentRepo.findById(id);
//
//        if(studentOptional.isEmpty()){
//            throw new IllegalStateException("Student with id " + id + "does not exist");
//        }
//        if(!Objects.equals(studentOptional.get().getName(),updatedStudent.getName())){
//            studentOptional.get().setName(updatedStudent.getName());
//        }
//
//        if(!Objects.equals(studentOptional.get().getEmail(),updatedStudent.getEmail())){
//            studentOptional.get().setEmail(updatedStudent.getEmail());
//        }
//
//        if(!Objects.equals(studentOptional.get().getDob(),updatedStudent.getDob())){
//            studentOptional.get().setDob(updatedStudent.getDob());
//        }
//
//        if(!Objects.equals(studentOptional.get().getAge(),updatedStudent.getAge())){
//            studentOptional.get().setAge(updatedStudent.getAge());
//        }
//    }

    @Transactional
    public void updateStudent(Long id, String name, String email){
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + "does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepo.findStudentByEmail(email);
            System.out.println("is present " + studentOptional.isPresent());
            if(studentOptional.isPresent()){
                throw new IllegalStateException("That email is already registered to another student");
            }
            student.setEmail(email);
        }
    }
}
