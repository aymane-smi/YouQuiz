package com.youquiz.youquiz.DTO;

import com.youquiz.youquiz.Enum.QuestionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QuestionDTO {
    private int id;
    @Min(value = 0, message = "response nomber must be greater or equql then 0")
    private int responseNbr;
    @Min(value = 0, message = "correct response nomber must be greater or equal then 0")
    private int correctResponseNbr;
    @NotBlank(message = "question body can't be empty")
    private String questionText;
    @NotNull(message = "the question required a type")
    private String type;
    @Min(value = 0, message = "total score can't be less then")
    private double totalScore;
    private long subject_id;
    private long level_id;
}
