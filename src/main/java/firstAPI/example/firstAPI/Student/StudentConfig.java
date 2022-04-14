package firstAPI.example.firstAPI.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo){
        return args -> {
            List<Student> list = new ArrayList<Student>();
            list.add(new Student(1L,
                    "Jeff",
                    "jeff@gmail.com",
                    LocalDate.of(1996, 9, 20)));
            list.add(new Student(2L,
                    "Bill",
                    "bill@gmail.com",
                    LocalDate.of(1994, 8, 6)));
            repo.saveAll(list);
        };
    }
}
