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
            message.put("message", "cannot delete this question");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{id}/medias")
    public ResponseEntity<Map<String, Object>> findQuestionMedia(@PathVariable long id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "medias found");
            message.put("medias", questionService.findQuestionMedia(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            message.put("message", "cannot found any media");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{id}/responses")
    public ResponseEntity<Map<String, Object>> findQuestionResponse(@PathVariable long id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "responses found");
            message.put("responses", questionService.findResponses(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            message.put("message", "cannot found any response");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllQuestion(){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "questions found");
            message.put("medias", questionService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            message.put("message", "cannot found any question");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
