package com.youquiz.youquiz.DTO.Response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CostumeResponseDTO {
    private long id;
    private String response;
    private double point;
    private int position;
}
