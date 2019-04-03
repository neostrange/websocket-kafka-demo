package com.example.websocketkafkademo.controller;



import com.example.websocketkafkademo.kafka.ChatOutput;
import com.example.websocketkafkademo.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;


@Controller
@EnableBinding(ChatOutput.class)
public class ChatController {

    @Autowired
    private ChatOutput chatOutput;



    private static String BOOT_TOPIC = "chatting";

    @MessageMapping("/chat.sendMessage")
    //@SendTo("/topic/public")
    public void sendMessage(@Payload ChatMessage chatMessage) {

        chatOutput.chatOutput().send(MessageBuilder.withPayload(chatMessage).build());
    }




    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
