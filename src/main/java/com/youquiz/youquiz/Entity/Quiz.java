package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Quiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
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
    @OneToOne(mappedBy = "quiz", fetch = FetchType.LAZY)
    private AssignQuiz assignQuiz;
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    private List<TempQuiz> tempoQuiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Trainer_id")
    private Trainer trainer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Subject_id")
    private Subject subject;
}
