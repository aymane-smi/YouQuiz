package com.youquiz.youquiz.DTO.Quiz;

import com.youquiz.youquiz.DTO.LevelDTO;
import com.youquiz.youquiz.DTO.MediaDTO;
import com.youquiz.youquiz.DTO.Subject.SubjectDTO;
import com.youquiz.youquiz.Enum.QuestionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class QuizResponseDTO {
    private Long id;
    @NotBlank(message = "question content should not be empty")
    private String questionText;
    @NotNull(message = "question type is required")
    private QuestionType questionType;
    @Min(value = 0, message = "total score can't be less than 0")
    private double totalScore;
    private SubjectDTO subject;
    private LevelDTO level;
    private List<MediaDTO> medias;
}
