package com.example.websocketkafkademo.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ChatOutput {

    String chatOutput = "chatOutput";

    @Output()
    MessageChannel chatOutput();
}
