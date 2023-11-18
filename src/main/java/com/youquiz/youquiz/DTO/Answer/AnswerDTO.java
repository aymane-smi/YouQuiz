package com.youquiz.youquiz.DTO.Answer;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerDTO {
    @NotNull(message = "assignquiz id is required")
    @Min(value = 1, message = "assignquiz id can't be under 1")
    private long assignQuiz_id;
    @NotNull(message = "validation id is required")
    @Min(value = 1, message = "validation id can't be under 1")
    private long validation_id;
}
