package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.LevelDTO;
import com.youquiz.youquiz.DTO.Question.QuestionWithoutDetailsDTO;
import com.youquiz.youquiz.Entity.Level;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.LevelRepository;
import com.youquiz.youquiz.Service.ILevelService;
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

    @Override
    public LevelDTO save(LevelDTO levelDTO) {
        Level level = modelMapper.map(levelDTO, Level.class);
        level = levelRepository.save(level);
        return modelMapper.map(level, LevelDTO.class);
    }

    @Override
    public LevelDTO update(long id, LevelDTO levelDTO) throws NotFoundException{
        Level level = levelRepository.findById(id).get();
        if(id <= 0 || level == null)
            throw new NotFoundException();
        level.setDescription(levelDTO.getDescription());
        level.setMaxScore(levelDTO.getMaxScore());
        level.setMinScore(level.getMinScore());
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

    @Override
    public List<QuestionWithoutDetailsDTO> findLevelQuestionById(long id) throws NotFoundException {
        if(id <= 0|| modelMapper.map(levelRepository.findById(id), LevelDTO.class) == null)
            throw new NotFoundException();
        System.out.println("size:"+levelRepository.findById(id).get().getQuestions());
        return Arrays.asList(modelMapper.map(levelRepository.findById(id).get().getQuestions(), QuestionWithoutDetailsDTO[].class));
    }

    @Override
    public void deleteById(long id) throws NotFoundException{
        if(id <= 0 || levelRepository.existsById(id) == false)
            throw new NotFoundException();
        levelRepository.deleteById(id);
    }

}
