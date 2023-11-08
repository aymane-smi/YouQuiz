package com.youquiz.youquiz.Entity;

import com.youquiz.youquiz.Enum.QuestionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Min(value = 0, message = "response nomber must be greater or equal then 0")
    private int responseNbr;
    @Column(nullable = false)
    @Min(value = 0, message = "correct response nomber must be greater or equal then 0")
    private int correctResponseNbr;
    @Column(nullable = false, length = 255)
    @NotBlank(message = "question body can't be empty")
    private String questionText;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "the question required a type")
    private QuestionType type;
    @Column(nullable = false)
    @Min(value = 0, message = "total score can't be less then")
    private double totalScore;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Validation> validations;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Media> medias;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Level_id")
    private Level level;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TempQuiz> tempoQuiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Subject_id")
    private Subject subject;
}
