package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Level implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 255)
    @NotBlank(message = "description can't be null")
    @NotNull(message = "description can't be empty")
    private String description;
    @Column(nullable = false)
    @Min(value = 0, message = "the minimum value is 0")
    private double maxScore;
    @Column(nullable = false)
    @Min(value = 0, message = "the minimum value is 0")
    private double minScore;
    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

}
