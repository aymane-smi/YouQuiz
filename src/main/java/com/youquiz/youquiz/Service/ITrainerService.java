package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.TrainerDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

import java.util.List;

public interface ITrainerService {
    TrainerDTO save(TrainerDTO trainerDto);

    void delete(Long id) throws NotFoundException;

    List<TrainerDTO> getAll();

    TrainerDTO findByID(Long id) throws NotFoundException;

    TrainerDTO update(Long id, TrainerDTO trainerDto) throws NotFoundException;
}
