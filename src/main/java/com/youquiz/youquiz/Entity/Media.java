package com.youquiz.youquiz.Entity;

import com.youquiz.youquiz.Enum.MediaType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Media implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MediaType type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Question_id")
    private Question question;
}
