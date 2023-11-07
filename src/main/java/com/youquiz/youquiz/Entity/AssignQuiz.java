package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
    @Column(nullable = false)
    private double score;
    @Column(nullable = false)
    private int played;
    @Column(nullable = false)
    private double result;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Student_id")
    private Student student;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="Quiz_id")
    private Quiz quiz;
    @OneToMany(mappedBy = "assignQuiz", fetch = FetchType.LAZY)
    private List<Answer> ansewrs;
}
