package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Trainer extends User{
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String role;
    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY)
    private List<Quiz> quizs;
}
