package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.Quiz.QuizDTO;
import com.youquiz.youquiz.DTO.Quiz.QuizResponseDTO;

import java.util.List;

public interface IQuizService {
    QuizDTO save(QuizDTO quizDto) throws Exception;

    void delete(long id) throws Exception;

    QuizResponseDTO findByID(long id) throws Exception;

    List<QuizResponseDTO> getAll();

    QuizDTO update(long id, QuizDTO quizDto) throws Exception;
}
