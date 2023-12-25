package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.ChatDTO;
import com.youquiz.youquiz.Entity.Chat;
import com.youquiz.youquiz.Repository.ChatRepository;
import com.youquiz.youquiz.Repository.StudentRepository;
import com.youquiz.youquiz.Repository.TrainerRepository;
import com.youquiz.youquiz.Service.ChatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public ChatDTO save(ChatDTO chat){
        Chat chatModel = modelMapper.map(chat, Chat.class);
        chatModel.setStudent(
                studentRepository.findById(chat.getStudent_id()).get()
        );
        chatModel.setTrainer(
                trainerRepository.findById(chat.getTrainer_id()).get()
        );
        chatModel = chatRepository.save(chatModel);
        return modelMapper.map(chatModel, ChatDTO.class);
    }
}
