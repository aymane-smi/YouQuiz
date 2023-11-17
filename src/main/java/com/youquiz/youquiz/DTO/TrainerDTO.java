package com.youquiz.youquiz.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TrainerDTO extends UserDTO{
    private int id;
    @NotBlank(message = "role can't be null or empty")
    private String role;
}
