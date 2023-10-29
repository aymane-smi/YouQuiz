package com.youquiz.youquiz.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LevelDTO {
    private int id;
    private String description;
    private double maxScore;
    private double minScore;
}
