package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.QuestionDTO;
import com.youquiz.youquiz.DTO.QuestionResponseDTO;

public interface IQuestionService{
    QuestionResponseDTO create(QuestionDTO questionDTO);
}
