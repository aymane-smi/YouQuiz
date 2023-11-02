package com.youquiz.youquiz.Rename;

import com.youquiz.youquiz.Entity.Question;
import com.youquiz.youquiz.Entity.Quiz;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
public class TempID implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Quiz quiz;
    private Question question;
}
