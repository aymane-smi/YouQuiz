package com.youquiz.youquiz.DTO;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuizDTO {
    private int id;
    private double score;
    private boolean showAnswears;
    private boolean showFinalResults;
    private int chanceNbr;
    private String remark;
}
