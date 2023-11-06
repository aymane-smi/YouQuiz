package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.LevelDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

public interface ILevelService {
    public LevelDTO save(LevelDTO level);
    public LevelDTO update(long id, LevelDTO level);
    public LevelDTO findById(long id) throws NotFoundException;
}
