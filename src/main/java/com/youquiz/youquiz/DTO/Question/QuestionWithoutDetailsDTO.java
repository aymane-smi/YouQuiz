package com.youquiz.youquiz.DTO.Question;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class QuestionWithoutDetailsDTO {
    private int id;
    private int responseNbr;
    private int correctResponseNbr;
    private String questionText;
    private String type;
    private double totalScore;
}
