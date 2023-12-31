package com.lsh.rabbitmqspring.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;


/**
 * @author lsh
 * @description: 队列TTL 消费者
 */
@Slf4j
@Component
public class DeadLetterQueueConsumer {

    @RabbitListener(queues = "QD")
    public void receiverD(Message message, Channel channel) {
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("当前时间:{},收到死信队列的消息:{}", new Date(), msg);
    }
}
