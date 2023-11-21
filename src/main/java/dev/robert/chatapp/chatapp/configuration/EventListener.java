package dev.robert.chatapp.chatapp.configuration;

import dev.robert.chatapp.chatapp.chat.Chat;
import dev.robert.chatapp.chatapp.chat.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
@RequiredArgsConstructor
public class EventListener {

    private final SimpMessageSendingOperations messageSendingOperations;

    @org.springframework.context.event.EventListener
    public void handleDisconnectListener(SessionDisconnectEvent disconnectEvent) {
        log.info("Disconnect event [sessionId: " + disconnectEvent.getSessionId() + "]");
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(disconnectEvent.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            log.info("User Disconnected: " + username);
            var chat = new Chat().builder().sender(username).type(MessageType.LEAVE).build();
            messageSendingOperations.convertAndSend("/topic/public", chat);
        }
    }
}
