package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Level implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 255)
    private String description;
    @Column(nullable = false)
    private double maxScore;
    @Column(nullable = false)
    private double minScore;
    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY)
    private List<Question> questions;

}
