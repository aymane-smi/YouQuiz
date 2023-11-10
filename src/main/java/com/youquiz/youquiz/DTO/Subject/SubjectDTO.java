package com.youquiz.youquiz.DTO.Subject;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SubjectDTO {
    private long id;
    @NotBlank(message = "title of the subject is required")
    private String title;
    private long parent_id;
}
