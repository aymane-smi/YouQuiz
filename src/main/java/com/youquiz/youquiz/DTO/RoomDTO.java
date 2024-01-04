package com.youquiz.youquiz.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RoomDTO {
    private long id;
    List<ChatDTO> chats;
}
