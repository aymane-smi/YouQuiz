package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
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
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 255)
    private String response;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "response", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Validation> validations;
}
