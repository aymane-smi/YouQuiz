package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="AssignQuizDTO")
@Data
@NoArgsConstructor
public class AssignQuiz {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private double score;
    @Column(nullable = false)
    private int played;
    @Column(nullable = false)
    private double result;
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name="quiz_id")
    private Quiz quiz;
}
