package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "validation")
@Immutable
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Validation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Response_id")
    @NonNull
    private Response response;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Question_id")
    @NonNull
    private Question question;
    @Column(nullable = false)
    @NonNull
    private double point;

    @OneToMany(mappedBy = "validation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;
}
