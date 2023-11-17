package com.youquiz.youquiz.DTO.Question;

import com.youquiz.youquiz.DTO.MediaDTO;
import com.youquiz.youquiz.Enum.QuestionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class QuestionDTO {
    private int id;
    @Min(value = 0, message = "response nomber must be greater or equql then 0")
    private int responseNbr;
    @Min(value = 0, message = "correct response nomber must be greater or equal then 0")
    private int correctResponseNbr;
    @NotBlank(message = "question body can't be empty")
    private String questionText;
    @NotNull(message = "the question required a type")
    private String type;
    @Min(value = 0, message = "total score can't be less then")
    private double totalScore;
    @NotNull(message = "question time must can't be empty")
    @Min(value = 10, message = "duration can't be under 10 second")
    private int duration;
    private long subject_id;
    private long level_id;
    private long quiz_id;
    private List<MediaDTO> medias;
}
