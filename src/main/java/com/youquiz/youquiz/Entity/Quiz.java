package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @OneToMany(mappedBy = "student")
    private List<AssignQuiz> assignQuizs;
    @OneToMany(mappedBy = "quiz")
    private List<Answer> answers;
    @OneToMany(mappedBy = "quiz")
    private List<TempQuiz> tempoQuiz;
}
