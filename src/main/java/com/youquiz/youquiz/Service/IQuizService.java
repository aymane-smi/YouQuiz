package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.Question.QuestionResponseDTO;
import com.youquiz.youquiz.DTO.Quiz.QuizDTO;

import java.util.List;

public interface IQuizService {
    QuizDTO save(QuizDTO quizDto) throws Exception;

    void delete(long id) throws Exception;

    QuizDTO findByID(long id) throws Exception;

    List<QuizDTO> getAll();

    QuizDTO update(long id, QuizDTO quizDto) throws Exception;

    List<QuestionResponseDTO> getQuizResponse(long id)throws Exception;
}
