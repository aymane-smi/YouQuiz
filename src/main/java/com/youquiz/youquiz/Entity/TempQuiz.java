package com.youquiz.youquiz.Entity;

import com.youquiz.youquiz.Rename.TempID;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Table
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TempQuiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @NonNull
    private TempID id;
    @NonNull
    private int time;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("Quiz_id")
    @NonNull
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("Question_id")
    @NonNull
    private Question question;
}
