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
public class Response {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 255)
    private String response;
    @Column(nullable = false)
    private double point;
}
