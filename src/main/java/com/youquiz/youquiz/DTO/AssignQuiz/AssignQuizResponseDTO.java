package com.youquiz.youquiz.DTO.AssignQuiz;

import com.youquiz.youquiz.DTO.Quiz.QuizDTO;
import com.youquiz.youquiz.DTO.StudentDTO;
import com.youquiz.youquiz.Enum.Result;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AssignQuizResponseDTO {
    private Long id;
    private Double score;
    private Integer played;
    private String reason;
    private Result result;
    private LocalDateTime debutDate;
    private LocalDateTime endDate;
    private StudentDTO student;
    private QuizDTO quiz;
}
