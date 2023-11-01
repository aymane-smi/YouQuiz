package com.youquiz.youquiz.Entity;

import com.youquiz.youquiz.Enum.MediaType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Media {
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
