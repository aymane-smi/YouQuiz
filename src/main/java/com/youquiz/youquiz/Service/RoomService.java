package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.RoomDTO;

public interface RoomService {
    RoomDTO create();

    RoomDTO getRoomChat(long id);
}
