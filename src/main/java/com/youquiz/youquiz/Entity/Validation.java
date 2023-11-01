package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.util.List;

@Entity
@Table(name = "validation")
@Immutable
public class Validation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Response_id")
    private Response response;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Question_id")
    private Question question;
    @Column(nullable = false)
    private double point;

    @OneToMany(mappedBy = "validation", fetch = FetchType.LAZY)
    private List<Answer> answers;
}
