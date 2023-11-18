package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.Question.QuestionDTO;
import com.youquiz.youquiz.DTO.tempoQuiz.TempoQuizDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Service.IMPL.QuestionService;
import com.youquiz.youquiz.Service.IMPL.TempoQuizService;
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
    @Autowired
    private TempoQuizService tempoQuizService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createQuestion(@Valid @RequestBody QuestionDTO questionDTO)throws Exception, NotFoundException {
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "question created");
            message.put("question", questionService.create(questionDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("cannot create a question");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateQuestion(@PathVariable long id, @RequestBody QuestionDTO questionDTO) throws Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "question updated");
            message.put("question", questionService.update(id, questionDTO));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot update this question");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteQuestion(@PathVariable long id)throws Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "question deleted");
            questionService.delete(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot delete this question");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findQuestion(@PathVariable long id)throws Exception, NotFoundException{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "question founded");
            message.put("question", questionService.findbydId(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot found this question");
        }
    }

    @GetMapping("/{id}/medias")
    public ResponseEntity<Map<String, Object>> findQuestionMedia(@PathVariable long id)throws Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "medias found");
            message.put("medias", questionService.findQuestionMedia(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot found any media");
        }
    }

    @GetMapping("/{id}/responses")
    public ResponseEntity<Map<String, Object>> findQuestionResponse(@PathVariable long id)throws Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "responses found");
            message.put("responses", questionService.findResponses(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot found any response");
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllQuestion()throws Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "questions found");
            message.put("medias", questionService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            throw new Exception("cannot found any question");
        }
    }

    @PostMapping("/{id}/addQuiz")
    public ResponseEntity<Map<String, Object>> addQuestiontoQuiz(@PathVariable long id, @Valid @RequestBody TempoQuizDTO tempoQuizDTO)throws Exception, NotFoundException{
        Map<String, Object> message = new HashMap<>();
            tempoQuizDTO.setQuestion_id(id);
            message.put("message", "question assigned to quiz");
            tempoQuizService.create(tempoQuizDTO);
            return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/{id}/detachQuiz/{quiz_id}")
    public ResponseEntity<Map<String, Object>> detachQuestiontoQuiz(@PathVariable long id, @PathVariable long quiz_id)throws Exception, NotFoundException{
        Map<String, Object> message = new HashMap<>();
        questionService.detachQuiz(id, quiz_id);
        message.put("message", "question detached to assigned quiz");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PatchMapping("/{id}/editTime")
    public ResponseEntity<Map<String, Object>> patchQuestionTime(@PathVariable long id, @Valid @RequestBody TempoQuizDTO tempoQuizDTO)throws Exception, NotFoundException{
        Map<String, Object> message = new HashMap<>();
        message.put("message", "question time changed");
        message.put("tempoQuiz", questionService.PatchQuiz(id, tempoQuizDTO));
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
