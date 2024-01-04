package com.youquiz.youquiz.DTO.Response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private long id;
    @NotBlank(message = "the response require a non empty string")
    private String response;
    @Min(value = 0, message = "the point can't be less then 0")
    private double point;
    @Min(value = 0, message = "invalid question id")
    @NotNull(message = "response require question id")
    private Long question_id;
    //@NotNull(message = "the position of a response is required")
    //@Min(value = 1, message = "the position value can't be less then 1")
    private int position;
}
