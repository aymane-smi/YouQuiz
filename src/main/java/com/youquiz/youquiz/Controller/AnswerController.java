package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.Answer.AnswerDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Service.AnswerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/answer")
@Validated
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @PostMapping
    public ResponseEntity<Map<String, Object>> createAnswer(@Valid @RequestBody AnswerDTO answerDTO)throws NotFoundException, Exception{
        Map<String, Object> message = new HashMap<>();
        answerService.create(answerDTO);
        message.put("message", "answer created");
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
