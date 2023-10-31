package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;

@Table
public class TempQuiz {
    private int time;
    private boolean disabled;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Quiz_id")
    private Quiz quiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Question_id")
    private Question question;
}
