package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;

@Entity
@Table(name = "Answer")
@Immutable
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Assign_id")
    private AssignQuiz assignQuiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Validation_id")
    private Validation validation;
}
