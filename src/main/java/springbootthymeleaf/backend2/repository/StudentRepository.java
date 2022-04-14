package springbootthymeleaf.backend2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootthymeleaf.backend2.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
