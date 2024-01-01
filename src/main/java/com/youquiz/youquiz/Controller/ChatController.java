package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.ChatDTO;
import com.youquiz.youquiz.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
//@CrossOrigin(origins = "http://localhost:5500")
public class ChatController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat")
    public void processDirectMessageFromClient(ChatDTO webSocketDirectMessage) {
        System.out.println(webSocketDirectMessage.getMessage());
        ChatDTO chat = chatService.save(webSocketDirectMessage);
        String channel = String.format("%d-%d", webSocketDirectMessage.getTrainer_id(), webSocketDirectMessage.getStudent_id());
        System.out.println(channel);
        messagingTemplate.convertAndSendToUser(channel, "/queue/messages", chat);
    }
    //@GetMapping("/{id}")

}
