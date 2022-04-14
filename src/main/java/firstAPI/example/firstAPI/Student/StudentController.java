package firstAPI.example.firstAPI.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/*
The student controller class serves as the api layer of the application and interacts with the service layer.
 */
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;
/*
    Use the AutoWired decorator to tell Spring that any parameters passed to the constructor should be
    instantiated and injected(dependency injection).
*/
    @Autowired
    public StudentController(StudentService studentService){
/*
        Should avoid this and use dependency injection as much as possible(good practise)
        this.studentService = new StudentService();
*/
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student){
        this.studentService.addNewStudent(student);
    }

    @DeleteMapping
    public void removeStudent(@RequestBody Student student){
        this.studentService.deleteStudent(student);
    }

/*
    //This was lecturers implementation
    @DeleteMapping(path="{studentId}")
    public void removeStudent(@PathVariable Long studentId){
        this.studentService.deleteStudent(studentId);
    }
*/

//    @PutMapping
//    public void putStudent(@RequestBody List<Student> args){
//        this.studentService.updateStudent(args.get(0), args.get(1));
//    }

//    @PutMapping
//    public void putStudent(@RequestBody Student[] args){
//        this.studentService.updateStudent(args[0], args[1]);
//    }

//    @PutMapping(path = "/update/{studentId}")
//    public void putStudent(@PathVariable Long studentId, @RequestBody Student student){
//        this.studentService.updateStudent(studentId, student);
//    }

    @PutMapping(path = "/update/{studentId}")
    public void putStudent(@PathVariable Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        this.studentService.updateStudent(studentId, name, email);
    }
}
