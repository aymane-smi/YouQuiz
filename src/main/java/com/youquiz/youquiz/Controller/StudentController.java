package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.StudentDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Service.IMPL.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findStudentByID(@PathVariable Long id) throws NotFoundException{
        StudentDTO studentDto = studentService.findByID(id);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping("/find/{page}")
    public ResponseEntity<List<StudentDTO>> findStudentByID(@PathVariable int page) throws NotFoundException{
        List<StudentDTO> studentDto = studentService.findByLimit(page);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents() {
        List<StudentDTO> students = studentService.getAll();
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) throws NotFoundException {
        studentService.delete(id);
        return new ResponseEntity<>("Trainer deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDTO studentDto) throws NotFoundException{
        StudentDTO updatedStudent = studentService.update(id, studentDto);
        return ResponseEntity.ok(updatedStudent);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDto) throws NotFoundException{
        StudentDTO updatedStudent = studentService.save(studentDto);
        return ResponseEntity.ok(updatedStudent);
    }
}