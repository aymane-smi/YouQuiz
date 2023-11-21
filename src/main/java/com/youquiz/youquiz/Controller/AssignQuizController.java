package com.youquiz.youquiz.Controller;
import com.youquiz.youquiz.DTO.AssignQuiz.AssignQuizDTO;
import com.youquiz.youquiz.DTO.AssignQuiz.AssignQuizResponseDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Service.IMPL.AssignQuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/ ", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class AssignQuizController {

    @Autowired
    private AssignQuizService assignQuizService;

    @PostMapping
    public ResponseEntity<List<AssignQuizDTO>> assignMultipleQuiz(@Valid @RequestBody List<AssignQuizDTO> assignQuizDtos) throws NotFoundException {
        List<AssignQuizDTO> savedAssignQuizzes = assignQuizService.saveAll(assignQuizDtos);
        return ResponseEntity.ok(savedAssignQuizzes);
    }

    @GetMapping
    public ResponseEntity<List<AssignQuizResponseDTO>> getAssignments() {
        List<AssignQuizResponseDTO> assignments = assignQuizService.getAll();
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignQuizResponseDTO> findAssignmentByID(@PathVariable Long id) throws NotFoundException{
        AssignQuizResponseDTO assignment = assignQuizService.findByID(id);
        return ResponseEntity.ok(assignment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable Long id) throws NotFoundException{
        assignQuizService.delete(id);
        return new ResponseEntity<>("Assignment deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignQuizDTO> updateAssignment(@PathVariable Long id, @Valid @RequestBody AssignQuizDTO assignQuizDto) throws NotFoundException{
        AssignQuizDTO updatedAssignment = assignQuizService.update(id, assignQuizDto);
        return ResponseEntity.ok(updatedAssignment);
    }
}