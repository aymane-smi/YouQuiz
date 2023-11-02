package com.youquiz.youquiz.Entity;

import com.youquiz.youquiz.Rename.TempID;
import jakarta.persistence.*;

import java.io.Serializable;

@Table
@Entity
public class TempQuiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private TempID id;
    private int time;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Quiz_id")
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Question_id")
    private Question question;
}
