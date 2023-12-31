package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.MediaDTO;
import com.youquiz.youquiz.DTO.Question.QuestionDTO;
import com.youquiz.youquiz.DTO.Question.QuestionResponseDTO;
import com.youquiz.youquiz.DTO.Response.ResponseDTO;
import com.youquiz.youquiz.DTO.tempoQuiz.TempoQuizDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

import java.util.List;

public interface IQuestionService{
    QuestionResponseDTO create(QuestionDTO questionDTO) throws NotFoundException;
    QuestionResponseDTO update(long id, QuestionDTO questionDTO) throws NotFoundException;
    void delete(long id) throws NotFoundException;
    List<MediaDTO> findQuestionMedia(long id) throws NotFoundException;
    List<QuestionResponseDTO> findAll();
    List<ResponseDTO> findResponses(long id) throws NotFoundException;

    void detachQuiz(long id, long quiz_id)throws NotFoundException, Exception;

    TempoQuizDTO PatchQuiz(long id, TempoQuizDTO tempoQuizDTO)throws NotFoundException, Exception;

    QuestionResponseDTO findbydId(long id) throws NotFoundException, Exception;
}
