package com.example.websocketkafkademo;

import com.example.websocketkafkademo.kafka.ChatInput;
import com.example.websocketkafkademo.kafka.ChatOutput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
@EnableBinding({ChatInput.class, ChatOutput.class})
public class WebsocketKafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketKafkaDemoApplication.class, args);
    }

}

