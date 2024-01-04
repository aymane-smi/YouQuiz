package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false)
    @NonNull
    private String message;
    @ManyToOne
    @JoinColumn(name="student_id", nullable = true)
    private Student student;
    @ManyToOne
    @JoinColumn(name="trainer_id", nullable = true)
    private Trainer trainer;
}
