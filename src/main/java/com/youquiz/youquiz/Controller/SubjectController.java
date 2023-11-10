package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.Subject.SubjectDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Service.IMPL.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @PostMapping
    public ResponseEntity<Map<String, Object>> createSubject(@Valid @RequestBody SubjectDTO subjectDTO){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "subject created");
            message.put("subject", subjectService.createSubject(subjectDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("error", "cannot create a new subject");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findSubject(@PathVariable long id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "subject found");
            message.put("subject", subjectService.findById(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(NotFoundException e){
            message.put("error", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            System.out.println(e.getMessage());
            message.put("error", "cannot create a new subject");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}/questions")
    public ResponseEntity<Map<String, Object>> findSubjectQuestionById(@PathVariable long id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "questions found");
            message.put("questions", subjectService.findSubjectQuestionById(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(NotFoundException e){
            message.put("error", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            System.out.println(e.getMessage());
            message.put("error", "cannot find any question subject");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteSubject(@PathVariable long id){
        Map<String, Object> message = new HashMap<>();
        try{
            subjectService.removeById(id);
            message.put("message", "subject deleted");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(NotFoundException e){
            message.put("error", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            System.out.println(e.getMessage());
            message.put("error", "cannot delete subject");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteSubject(@PathVariable long id, @Valid @RequestBody SubjectDTO subjectDTO){
        Map<String, Object> message = new HashMap<>();
        try{
            SubjectDTO subject = subjectService.updateSubject(id, subjectDTO);
            if(subject == null)
                throw new Exception("there is not value to be updated");
            message.put("message", "subject updated");
            message.put("subject", subject);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(NotFoundException e){
            message.put("error", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            System.out.println(e.getMessage());
            message.put("error", "cannot update subject");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllSubject(){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "subjects found");
            message.put("subjects", subjectService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            message.put("error", "cannot find any subject");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
