package com.youquiz.youquiz.DTO.Quiz;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuizDTO {
    private Long id;
    @NotNull(message = "score is required")
    @Min(value = 0, message = "the minimum score is 0")
    private Double score;
    @NotNull(message = "show answers is required")
    private Boolean showAnswers;
    @NotNull(message = "show final results is required")
    private Boolean showFinalResults;
    @NotNull(message = "chance num is required")
    @Min(value = 1, message = "the minimum num of chances is 1")
    private Integer chanceNbr;
    @NotNull(message = "duration is required")
    @Min(value = 30, message = "the minimum duration of a quiz is 30 min")
    private Integer durationInMinutes;
    private String remark;
    @NotNull(message = "trainer id is required")
    private Long trainer_id;

}
