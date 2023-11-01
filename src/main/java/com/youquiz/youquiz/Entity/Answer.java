package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
@Entity
@Table(name = "Answer")
@Immutable
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    private int played;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Assign_id")
    private AssignQuiz assignQuiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Validation_id")
    private Validation validation;
}
