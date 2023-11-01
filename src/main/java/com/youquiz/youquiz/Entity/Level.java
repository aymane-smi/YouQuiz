package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Level {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 255)
    private String description;
    @Column(nullable = false)
    private double maxScore;
    @Column(nullable = false)
    private double minScore;
    @OneToOne(fetch = FetchType.LAZY)
    @Column(name="Question_id")
    private Question question;

}
