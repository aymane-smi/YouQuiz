package com.youquiz.youquiz.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SubjectResponseDTO {
    private long id;
    @NotBlank(message = "title of the subject is required")
    private String title;
    private SubjectResponseDTO parent;
    private List<SubjectDTO> childs;
}
