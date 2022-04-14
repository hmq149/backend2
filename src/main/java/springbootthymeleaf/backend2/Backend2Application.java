package springbootthymeleaf.backend2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springbootthymeleaf.backend2.entity.Student;
import springbootthymeleaf.backend2.repository.StudentRepository;

@SpringBootApplication
public class Backend2Application implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(Backend2Application.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;


	@Override
	public void run(String... args) throws Exception {
		/*Student student1 = new Student("Hoàng","Quân","hmq@gmail.com");
		studentRepository.save(student1);
		Student student2 = new Student("Ngô","Minh","nqm@gmail.com");
		studentRepository.save(student2);*/
	}
}
