package com.youquiz.youquiz.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Level {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 255)
    private String description;
    @Column(nullable = false)
    private double maxScore;
    @Column(nullable = false)
    private double minScore;

}
