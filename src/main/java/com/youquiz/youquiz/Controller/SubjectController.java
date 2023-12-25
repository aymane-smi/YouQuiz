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
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @PostMapping
    public ResponseEntity<Map<String, Object>> createSubject(@Valid @RequestBody SubjectDTO subjectDTO)throws Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "subject created");
            message.put("subject", subjectService.createSubject(subjectDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            throw new Exception("cannot create a new subject");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findSubject(@PathVariable long id)throws NotFoundException, Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "subject found");
            message.put("subject", subjectService.findById(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(NotFoundException e){
            throw new NotFoundException(e.getMessage());
        }catch(Exception e){
            throw new Exception("cannot create a new subject");
        }
    }
    @GetMapping("/{id}/questions")
    public ResponseEntity<Map<String, Object>> findSubjectQuestionById(@PathVariable long id)throws NotFoundException, Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "questions found");
            message.put("questions", subjectService.findSubjectQuestionById(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(NotFoundException e){
            throw new NotFoundException(e.getMessage());
        }catch(Exception e){
            throw new Exception("cannot find any question subject");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteSubject(@PathVariable long id)throws Exception, NotFoundException{
        Map<String, Object> message = new HashMap<>();
        try{
            subjectService.removeById(id);
            message.put("message", "subject deleted");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(NotFoundException e){
            throw new Exception(e.getMessage());
        }catch(Exception e){
            throw new Exception("cannot delete subject");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> editSubject(@PathVariable long id, @Valid @RequestBody SubjectDTO subjectDTO)throws NotFoundException, Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            SubjectDTO subject = subjectService.updateSubject(id, subjectDTO);
            if(subject == null)
                throw new Exception("there is not value to be updated");
            message.put("message", "subject updated");
            message.put("subject", subject);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(NotFoundException e){
            throw new NotFoundException(e.getMessage());
        }catch(Exception e){
            throw new Exception("cannot update subject");
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllSubject()throws Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "subjects found");
            message.put("subjects", subjectService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot find any subject");
        }
    }
}
