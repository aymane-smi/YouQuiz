package com.youquiz.youquiz.Rename;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
public class TempID implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Column(name = "Quiz_id")
    private Long quiz;
    @Column(name = "Question_id")
    private Long question;
}
