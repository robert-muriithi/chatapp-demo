package dev.robert.chatapp.chatapp.chat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chat {
    private String message;
    private String sender;
    private MessageType type;
}
