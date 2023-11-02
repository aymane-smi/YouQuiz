package com.youquiz.youquiz.Entity;

import com.youquiz.youquiz.Enum.QuestionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
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
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Validation> validations;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Media> medias;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Level_id")
    private Level level;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<TempQuiz> tempoQuiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Subject_id")
    private Subject subject;
}
