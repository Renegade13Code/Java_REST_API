package firstAPI.example.firstAPI;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import firstAPI.example.firstAPI.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FirstApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApiApplication.class, args);
	}

}
