package com.youquiz.youquiz.DTO;

import com.youquiz.youquiz.DTO.Question.QuestionDTO;
import com.youquiz.youquiz.DTO.Response.ResponseDTO;
import lombok.Data;

@Data
public class ValidationDTO  {
    private long id;
    private QuestionDTO question;
    private ResponseDTO responseDTO;
    private double point;
}
