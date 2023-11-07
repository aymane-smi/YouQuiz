package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.SubjectDTO;
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
            message.put("message", "cannot create a new subject");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> createSubject(@PathVariable long id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "subject found");
            message.put("subject", subjectService.findById(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(NotFoundException e){
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            System.out.println(e.getMessage());
            message.put("message", "cannot create a new subject");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
