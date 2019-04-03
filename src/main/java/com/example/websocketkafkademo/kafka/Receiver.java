package com.example.websocketkafkademo.kafka;


import com.example.websocketkafkademo.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@EnableBinding(ChatInput.class)
@Component
public class Receiver {

    @Autowired
//    @Qualifier("brokerMessagingTemplate")
//    private SimpMessagingTemplate template;
    private SimpMessageSendingOperations template;

    @StreamListener(ChatInput.chatInput)
    public void processMessage(ChatMessage pushMessage)
    {

        pushMessage.setContent(pushMessage.getContent()+" - processed for: "+pushMessage.getSender());

        this.template.convertAndSend("/topic/"+pushMessage.getSender(), pushMessage);
       // this.template.convertAndSend("/topic/public", pushMessage);
    }
}





//@Service
//public class Receiver {
//    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
//
//    private CountDownLatch latch = new CountDownLatch(1);
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }
//
//    @Autowired
//    private SimpMessagingTemplate template;
//
//    @KafkaListener(topics = "${topic.boot}")
//    public void receive(ConsumerRecord<?, ?> consumerRecord) throws Exception {
//        LOGGER.info("received data='{}'", consumerRecord.toString());
//        String[] message = consumerRecord.value().toString().split("\\|");
//        LOGGER.info("message='{}'", Arrays.toString(message));
//        ChatMessage chatMessage = new ChatMessage();
//        chatMessage.setContent(consumerRecord.value().toString());
//        this.template.convertAndSend("/topic/public",chatMessage );
//        latch.countDown();
//    }
//}