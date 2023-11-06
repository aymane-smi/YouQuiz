package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.LevelDTO;
import com.youquiz.youquiz.Entity.Level;
import com.youquiz.youquiz.Repository.LevelRepository;
import com.youquiz.youquiz.Service.ILevelService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelService implements ILevelService {
    @Autowired
    private ModelMapper modelMapper;
    private final LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public LevelDTO save(LevelDTO levelDTO) {
        Level level = modelMapper.map(levelDTO, Level.class);
        level = levelRepository.save(level);
        return modelMapper.map(level, LevelDTO.class);
    }
}
