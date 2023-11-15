package com.youquiz.youquiz.DTO;

import com.youquiz.youquiz.DTO.Question.QuestionDTO;
import com.youquiz.youquiz.Enum.MediaType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaDTO {
    private int id;
    private String name;
    private MediaType type;
    private QuestionDTO questionDTO;
}
