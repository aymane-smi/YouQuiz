package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.Quiz.QuizDTO;
import com.youquiz.youquiz.DTO.Quiz.QuizResponseDTO;
import com.youquiz.youquiz.Service.IMPL.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/quiz", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<QuizDTO> createQuiz(@Valid @RequestBody QuizDTO quizDto)throws Exception {
        QuizDTO createdQuiz = quizService.save(quizDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
    }
    @GetMapping
    public ResponseEntity<List<QuizResponseDTO>> getQuizzes() {
        List<QuizResponseDTO> allQuizzes = quizService.getAll();
        return ResponseEntity.ok(allQuizzes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> findQuizByID(@PathVariable Long id)throws Exception {
        QuizResponseDTO quiz = quizService.findByID(id);
        return ResponseEntity.ok(quiz);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Long id) throws Exception{
        quizService.delete(id);
        return new ResponseEntity<>("Quiz deleted successfully", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<QuizDTO> updateQuiz(@PathVariable Long id, @Valid @RequestBody QuizDTO quizDto)throws Exception {
        QuizDTO updatedQuiz = quizService.update(id, quizDto);
        return ResponseEntity.ok(updatedQuiz);
    }
}