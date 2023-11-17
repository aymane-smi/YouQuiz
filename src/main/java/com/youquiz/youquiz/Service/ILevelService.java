package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.LevelDTO;
import com.youquiz.youquiz.DTO.Question.QuestionWithoutDetailsDTO;
import com.youquiz.youquiz.DTO.QuestionResponseDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

import java.util.List;

public interface ILevelService {
    public LevelDTO save(LevelDTO level);
    public LevelDTO update(long id, LevelDTO level) throws NotFoundException;
    public LevelDTO findById(long id) throws NotFoundException;

    public List<LevelDTO> findAll();
    public List<QuestionWithoutDetailsDTO> findLevelQuestionById(long id) throws NotFoundException;

}
