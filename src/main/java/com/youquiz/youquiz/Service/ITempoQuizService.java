package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.TempoQuizDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

public interface ITempoQuizService {
    void create(TempoQuizDTO tempQuiz) throws NotFoundException, Exception;
}
