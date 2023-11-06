package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.LevelDTO;
import com.youquiz.youquiz.Entity.Level;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.LevelRepository;
import com.youquiz.youquiz.Service.ILevelService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LevelService implements ILevelService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LevelRepository levelRepository;

    //public LevelService(LevelRepository levelRepository) {
        //this.levelRepository = levelRepository;
    //}

    @Override
    public LevelDTO save(LevelDTO levelDTO) {
        Level level = modelMapper.map(levelDTO, Level.class);
        level = levelRepository.save(level);
        return modelMapper.map(level, LevelDTO.class);
    }

    @Override
    public LevelDTO update(long id, LevelDTO levelDTO) {
        Level level = modelMapper.map(levelDTO, Level.class);
        level.setId(id);
        System.out.println("id:"+level.getId());
        level = levelRepository.save(level);
        return modelMapper.map(level, LevelDTO.class);
    }

    @Override
    public LevelDTO findById(long id) throws NotFoundException{
        if(modelMapper.map(levelRepository.findById(id), LevelDTO.class) == null)
            throw new NotFoundException();
        return modelMapper.map(levelRepository.findById(id), LevelDTO.class);
    }

    @Override
    public List<LevelDTO> findAll() {
        return Arrays.asList(modelMapper.map(levelRepository.findAll(), LevelDTO[].class));
    }
}
