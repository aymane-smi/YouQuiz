package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Sub_Parent")
    private Subject parent;
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Subject> childs;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Question> questions;
}
