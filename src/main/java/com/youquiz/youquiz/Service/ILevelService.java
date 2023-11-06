package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.LevelDTO;

public interface ILevelService {
    public LevelDTO save(LevelDTO level);
    public LevelDTO update(long id, LevelDTO level);
}
