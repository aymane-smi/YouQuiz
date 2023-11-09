package com.youquiz.youquiz.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {
    @NotBlank(message = "the response require a non empty string")
    private String response;
    @Min(value = 0, message = "the point can't be less then 0")
    private double point;
    @Min(value = 0, message = "invalid question id")
    @NotNull(message = "response require question id")
    private long question_id;
}
