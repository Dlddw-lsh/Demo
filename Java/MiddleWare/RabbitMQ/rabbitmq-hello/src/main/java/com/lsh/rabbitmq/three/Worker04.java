package com.lsh.rabbitmq.three;

import com.lsh.rabbitmq.utils.RabbitUtils;
import com.lsh.rabbitmq.utils.SleepUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Worker04 {
    public static final String TASK_QUEUE_NAME = "ask_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitUtils.getChannel();
        System.out.println("C2等待接受消息处理时间较长");

        // 采用手动应答
        channel.basicConsume(TASK_QUEUE_NAME, false, ((consumerTag, message) -> {

            System.out.println("C2接受到的消息:" + new String(message.getBody()));
            // 沉睡30s
            SleepUtils.sleep(30);
            // 手动应答
            /*
             * 1.消息的标记
             * 2.是否批量应答
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
            System.out.println("C2消息处理完毕:" + new String(message.getBody()));
        }), consumerTag -> {
            System.out.println("消息取消的回调");
        });
    }
}