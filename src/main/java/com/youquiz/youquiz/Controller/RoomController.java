package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.ChatDTO;
import com.youquiz.youquiz.DTO.RoomDTO;
import com.youquiz.youquiz.Entity.Room;
import com.youquiz.youquiz.Service.ChatService;
import com.youquiz.youquiz.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
//@CrossOrigin(origins = "http://localhost:5500")
public class RoomController {
    private SimpMessagingTemplate messagingTemplate;
    private ChatService chatService;
    private RoomService roomService;
    @Autowired
    public RoomController(
            SimpMessagingTemplate messagingTemplate,
            ChatService chatService,
            RoomService roomService
    ){
        this.messagingTemplate = messagingTemplate;
        this.chatService = chatService;
        this.roomService = roomService;
    }

    @MessageMapping("/room")
    public void processDirectMessageFromClient(ChatDTO webSocketDirectMessage) {
        long roomId = webSocketDirectMessage.getRoom_id();
        ChatDTO chat = chatService.save(webSocketDirectMessage);

        //String channel = String.format("%d-%d", webSocketDirectMessage.getTrainer_id(), webSocketDirectMessage.getStudent_id());
        messagingTemplate.convertAndSendToUser(roomId+"", "/queue/messages", chat);
    }
    @GetMapping("/{id}")
    public RoomDTO getRoomChats(@PathVariable long id){
        return roomService.getRoomChat(id);
    }
    @PostMapping
    public RoomDTO createRoom(){
        return roomService.create();
    }

}
