package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
@Inheritance
@Entity
public class Student extends User{
    @Id
    @GeneratedValue
    private int id;
    private LocalDate dateOfInscription;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<AssignQuiz> assignQuiz;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Answer> answers;
}
