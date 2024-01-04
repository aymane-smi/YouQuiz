package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.RoomDTO;
import com.youquiz.youquiz.Entity.Room;
import com.youquiz.youquiz.Repository.RoomRepository;
import com.youquiz.youquiz.Service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService{

    private ModelMapper modelMapper;
    private RoomRepository roomRepository;
    @Autowired
    public RoomServiceImpl(
            ModelMapper modelMapper,
            RoomRepository roomRepository){
        this.modelMapper = modelMapper;
        this.roomRepository = roomRepository;
    }
    @Override
    public RoomDTO create(){
        Room room = new Room();
        room = roomRepository.save(room);
        return modelMapper.map(room, RoomDTO.class);
    }

    @Override
    public RoomDTO getRoomChat(long id){
        return modelMapper.map(roomRepository.findById(id), RoomDTO.class);
    }
}
