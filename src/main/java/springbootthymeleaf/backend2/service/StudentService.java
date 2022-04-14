package springbootthymeleaf.backend2.service;


import springbootthymeleaf.backend2.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

}

