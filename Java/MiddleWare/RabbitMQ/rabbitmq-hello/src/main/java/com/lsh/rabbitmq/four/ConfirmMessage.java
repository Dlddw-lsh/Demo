package com.lsh.rabbitmq.four;

import com.lsh.rabbitmq.utils.RabbitUtils;
import com.rabbitmq.client.Channel;

import java.util.UUID;

/**
 * 发布确认模式
 * 使用的时间 比较哪种方式最好
 * 1.单个确认       -->     1575ms
 * 2.批量确认       -->     171ms
 * 3.异步批量确认
 */
public class ConfirmMessage {
    private static final int MESSAGE_COUNT = 1000;

    public static void main(String[] args) throws Exception {
        // 1.单个确认
        publicMessageIndividually();
        // 2.批量确认
        publishMessageBatch();
        // 3.异步批量确认
    }

    // 单个确认
    private static void publicMessageIndividually() throws Exception {
        Channel channel = RabbitUtils.getChannel();
        // 队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, true, false, false, null);
        // 开启发布确认
        channel.confirmSelect();

        // 开始时间
        long begin = System.currentTimeMillis();

        // 批量发消息
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            // 单个消息就马上进行发布确认
            boolean success = channel.waitForConfirms();
            if (success) {
                System.out.println("消息发送成功");
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个单独确认消息，耗时" + (end - begin) + "ms");
    }

    // 批量发布确认
    public static void publishMessageBatch() throws Exception {
        Channel channel = RabbitUtils.getChannel();
        // 队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, true, false, false, null);
        // 开启发布确认
        channel.confirmSelect();

        // 开始时间
        long begin = System.currentTimeMillis();

        // 批量确认消息的大小
        int batchSize = 100;
        // 批量发消息
        for (int i = 1; i <= MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());

            // 判断达到100条消息的时候 批量确认一次
            if (i % batchSize == 0) {
                // 发布确认
                channel.waitForConfirms();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个批量确认消息，耗时" + (end - begin) + "ms");
    }
}
