package com.youquiz.youquiz.Entity;

import com.youquiz.youquiz.Enum.QuestionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private int responseNbr;
    @Column(nullable = false)
    private int correctResponseNbr;
    @Column(nullable = false, length = 255)
    private String questionText;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionType type;
    @Column(nullable = false)
    private double totalScore;
}
