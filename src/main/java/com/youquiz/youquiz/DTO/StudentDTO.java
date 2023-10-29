package com.youquiz.youquiz.DTO;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@Data
public class StudentDTO extends UserDTO{
    private int id;
    private LocalDate dateOfInscription;
}
