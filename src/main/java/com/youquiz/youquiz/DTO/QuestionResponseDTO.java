package com.youquiz.youquiz.DTO;

import com.youquiz.youquiz.Enum.QuestionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QuestionResponseDTO {
    private int id;
    private int responseNbr;
    private int correctResponseNbr;
    private String questionText;
    private QuestionType type;
    private double totalScore;
    private SubjectDTO subject;
    private LevelDTO level;
}
