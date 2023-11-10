package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.Question.QuestionDTO;
import com.youquiz.youquiz.DTO.QuestionResponseDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

public interface IQuestionService{
    QuestionResponseDTO create(QuestionDTO questionDTO);
    QuestionResponseDTO update(long id, QuestionDTO questionDTO) throws NotFoundException;
    void delete(long id) throws NotFoundException;
}
