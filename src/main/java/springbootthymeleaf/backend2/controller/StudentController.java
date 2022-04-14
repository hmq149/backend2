package springbootthymeleaf.backend2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootthymeleaf.backend2.entity.Student;
import springbootthymeleaf.backend2.service.StudentService;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //handler method to handle list students and return mode and view
    @GetMapping
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("students") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";

    }
}
