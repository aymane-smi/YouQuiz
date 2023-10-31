package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Subject {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 100)
    private String title;
    @ManyToOne
    @JoinColumn(name = "Sub_Parent")
    private Subject parent;
    @OneToMany(mappedBy = "parent")
    private List<Subject> childs;
}
