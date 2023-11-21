package com.youquiz.youquiz.Entity;

import com.youquiz.youquiz.Enum.Result;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="AssignQuiz")
@Getter
@Setter
@NoArgsConstructor
public class AssignQuiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @OneToMany(mappedBy = "assignQuiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;
    @Override
    public String toString(){
        return "to string ta3 zab";
    }
}
