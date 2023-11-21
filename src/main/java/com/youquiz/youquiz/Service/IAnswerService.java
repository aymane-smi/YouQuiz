package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.Answer.AnswerDTO;
import com.youquiz.youquiz.DTO.Response.CostumeResponseDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

import java.util.List;

public interface IAnswerService {
    void create(AnswerDTO answerDTO) throws Exception;

    List<CostumeResponseDTO> findResponseofUserQuiz(long assignQuiz_id)throws NotFoundException, Exception;
}
