package springbootthymeleaf.backend2.service.impl;

import org.springframework.stereotype.Service;
import springbootthymeleaf.backend2.entity.Student;
import springbootthymeleaf.backend2.repository.StudentRepository;
import springbootthymeleaf.backend2.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentByID(Long id) {
        studentRepository.deleteById(id);
    }


}
