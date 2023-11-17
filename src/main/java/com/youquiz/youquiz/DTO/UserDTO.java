package com.youquiz.youquiz.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class UserDTO {
    @NotBlank(message = "first name can't be null or empty")
    private String firstName;
    @NotBlank(message = "first name can't be null or empty")
    private String lastName;
    @NotNull(message = "date can't be null")
    private LocalDate birthDay;
    @NotBlank(message = "address can't be null or empty")
    private String address;
}
