package com.youquiz.youquiz.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Inheritance;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Inheritance
@Entity
public class Student extends User{
    @Id
    @GeneratedValue
    private int id;
    @Column
    private LocalDate dateOfInscription;
}
