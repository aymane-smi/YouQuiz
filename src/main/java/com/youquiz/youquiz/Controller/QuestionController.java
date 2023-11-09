package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.Question.QuestionDTO;
import com.youquiz.youquiz.Service.IMPL.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createQuestion(@Valid @RequestBody QuestionDTO questionDTO){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "question created");
            message.put("question", questionService.create(questionDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("message", "cannot create a question");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateQuestion(@PathVariable long id, @RequestBody QuestionDTO questionDTO){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "question updated");
            message.put("question", questionService.update(id, questionDTO));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            System.out.println("error:"+e.getMessage());
            message.put("message", "cannot update this question");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteQuestion(@PathVariable long id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "question deleted");
            questionService.delete(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            System.out.println("error:"+e.getMessage());
            message.put("message", "cannot delete this question");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
