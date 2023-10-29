package com.youquiz.youquiz.DTO;

import com.youquiz.youquiz.Enum.QuestionType;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QuestionDTO {
    private int id;
    private int responseNbr;
    private int correctResponseNbr;
    private String questionText;
    private QuestionType type;
    private double totalScore;
}
