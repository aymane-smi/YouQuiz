package com.youquiz.youquiz.DTO;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private String address;
}
