package com.youquiz.youquiz.DTO;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private int id;
    private String response;
    private double point;
}
