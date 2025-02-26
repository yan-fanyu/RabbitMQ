package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendMessage2Queue(){
        String queueName = "simple.queue";
        String msg = "hello, amqp";
        rabbitTemplate.convertAndSend(queueName, msg);
    }
    @Test
    void testSendMessage2WorkQueue(){
        String queueName = "work.queue";
        for (int i = 0; i < 50; i++) {
            String msg = "hello, work.queue_"+i;
            rabbitTemplate.convertAndSend(queueName, msg);
        }
    }
    @Test
    void testSendFanout(){
        String exchangeName = "hmall.fanout";
        String msg = "hello, hmall.fanout";
        rabbitTemplate.convertAndSend(exchangeName, null, msg);

    }

    @Test
    void testSendDirect(){
        String exchangeName = "hmall.direct";
        String msg = "hello, hmall.direct";
        rabbitTemplate.convertAndSend(exchangeName, "yellow", msg);
    }

    @Test
    void testSendTopic(){
        String exchangeName = "hmall.topic";
        String msg = "hello, hmall.topic";
        rabbitTemplate.convertAndSend(exchangeName, "china.news", msg);
    }
}
