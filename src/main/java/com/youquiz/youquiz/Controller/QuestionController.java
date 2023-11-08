package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.QuestionDTO;
import com.youquiz.youquiz.Service.IMPL.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
