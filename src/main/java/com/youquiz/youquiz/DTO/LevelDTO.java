package com.youquiz.youquiz.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LevelDTO {
    private long id;
    @NotBlank(message = "description can't be null")
    private String description;
    @NotNull(message = "maxScore can't be null")
    @Min(value = 0, message = "the minimum value is 0")
    private double maxScore;
    @NotNull(message = "minScore can't be null")
    @Min(value = 0, message = "the minimum value is 0")
    private double minScore;
}
