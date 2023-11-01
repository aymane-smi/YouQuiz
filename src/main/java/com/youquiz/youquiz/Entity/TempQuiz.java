package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;

@Table
@Entity
public class TempQuiz {
    @Id
    @GeneratedValue
    private Long id;
    private int time;
    private boolean disabled;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Quiz_id")
    private Quiz quiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Question_id")
    private Question question;
}
