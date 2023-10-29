package com.youquiz.youquiz.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private double score;
    @Column(nullable = false)
    private boolean showAnswers;
    @Column(nullable = false)
    private boolean showFinalResults;
    @Column(nullable = false)
    private int chanceNbr;
    @Column(nullable = false)
    private String remark;
}
