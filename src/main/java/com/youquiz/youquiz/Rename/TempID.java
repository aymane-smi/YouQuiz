package com.youquiz.youquiz.Rename;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class TempID implements Serializable {
    private static final Long serialVersionUID = 1L;
    @NonNull
    @Column(name = "Quiz_id")
    private Long quiz;
    @NonNull
    @Column(name = "Question_id")
    private Long question;
}
