package springbootthymeleaf.backend2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";

    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping(value = "/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student){

        // get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save update student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";

    }

    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentByID(id);
        return "redirect:/students";
    }

}
