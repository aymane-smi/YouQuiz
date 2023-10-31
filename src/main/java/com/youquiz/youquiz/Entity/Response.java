package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Response {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 255)
    private String response;
    @Column(nullable = false)
    private double point;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "response")
    private List<Validation> validations;
}
