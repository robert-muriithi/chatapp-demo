package dev.robert.chatapp.chatapp.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Chat sendMessage(@Payload Chat chat) {
        return chat;
    }

    @MessageMapping("/chat.addNewUser")
    @SendTo("/topic/public")
    public Chat addNewUser(@Payload Chat chat, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chat.getSender());
        return chat;
    }
}
