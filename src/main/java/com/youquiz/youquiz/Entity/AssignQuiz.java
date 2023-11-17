package com.youquiz.youquiz.Entity;

import com.youquiz.youquiz.Enum.Result;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="AssignQuiz")
@Data
@NoArgsConstructor
public class AssignQuiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Min(value = 0, message = "score can't be negative")
    private Double score;

    @Column
    @NotNull(message = "played can't be null")
    private Integer played;

    @Column
    @Enumerated(EnumType.STRING)
    private Result result;

    @Column
    private String reason;

    @Column
    @NotNull(message = "debut date can't be null")
    private LocalDateTime debutDate;

    @Column
    @NotNull(message = "debut date can't be null")
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "assignQuiz", fetch = FetchType.LAZY)
    private List<Answer> answers;
}
