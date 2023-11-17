package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.TrainerDTO;
import com.youquiz.youquiz.Entity.Trainer;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.TrainerRepository;
import com.youquiz.youquiz.Service.ITrainerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService implements ITrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TrainerDTO save(TrainerDTO trainerDto) {
        Trainer trainer = modelMapper.map(trainerDto, Trainer.class);
        Trainer savedTrainer = trainerRepository.save(trainer);
        return modelMapper.map(savedTrainer, TrainerDTO.class);
    }

    @Override
    public void delete(Long id) throws NotFoundException{
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        trainerRepository.delete(trainer);
    }

    @Override
    public List<TrainerDTO> getAll() {
        List<Trainer> trainers = trainerRepository.findAll();
        return trainers.stream()
                .map(trainer -> modelMapper.map(trainer, TrainerDTO.class))
                .toList();
    }

    @Override
    public TrainerDTO findByID(Long id) throws NotFoundException{
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        return modelMapper.map(trainer, TrainerDTO.class);
    }

    @Override
    public TrainerDTO update(Long id, TrainerDTO trainerDto) throws NotFoundException{
        Trainer existingTrainer = trainerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        existingTrainer.setFirstName(trainerDto.getFirstName());
        existingTrainer.setLastName(trainerDto.getLastName());
        existingTrainer.setBirthDay(trainerDto.getBirthDay());
        existingTrainer.setAddress(trainerDto.getAddress());
        existingTrainer.setRole(trainerDto.getRole());
        Trainer updatedTrainer = trainerRepository.save(existingTrainer);
        return modelMapper.map(updatedTrainer, TrainerDTO.class);
    }
}