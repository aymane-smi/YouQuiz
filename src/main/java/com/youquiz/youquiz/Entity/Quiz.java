package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @Column(name = "duration", nullable = false)
    @NotNull(message = "duration is required")
    @Min(value = 30, message = "the minimum duration of a quiz is 30 min")
    private Integer durationInMinutes;
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "AssignQuiz_id")
    private List<AssignQuiz> assignQuiz;
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TempQuiz> tempoQuiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Trainer_id")
    private Trainer trainer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Subject_id")
    private Subject subject;
}
