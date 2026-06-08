package firstProject.example.tahseenOuda.controller;

import firstProject.example.tahseenOuda.model.Student;
import firstProject.example.tahseenOuda.model.StudentRequest;
import firstProject.example.tahseenOuda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody StudentRequest request) {
        Student student = new Student(request.getName(), request.getMajor(), request.getGrade());
        return studentService.saveOrUpdateStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentRequest request) {
        Optional<Student> studentOptional = studentService.getStudentById(id);

        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();
            existingStudent.setName(request.getName());
            existingStudent.setMajor(request.getMajor());
            existingStudent.setGrade(request.getGrade());

            Student updatedStudent = studentService.saveOrUpdateStudent(existingStudent);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            studentService.deleteStudentById(id);
            return ResponseEntity.ok("Student deleted successfully with ID: " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}