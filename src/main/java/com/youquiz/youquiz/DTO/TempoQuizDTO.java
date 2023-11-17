package com.youquiz.youquiz.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.aspectj.bridge.IMessage;

@Data
@NoArgsConstructor
public class TempoQuizDTO {
    //@NotNull(message = "question id can't be null")
    //@Min(value = 1, message = "question id can't be less then 1")
    private long question_id;
    @NotNull(message = "quiz id can't be null")
    @Min(value = 1, message = "quiz id can't be less then 1")
    private long quiz_id;
    @NotNull(message = "question time must can't be empty")
    @Min(value = 10, message = "duration can't be under 10 second")
    private int duration;
}
