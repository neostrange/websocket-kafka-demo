package com.example.websocketkafkademo.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ChatInput {
    String chatInput = "chatInput";

    @Input()
    SubscribableChannel chatInput();
}