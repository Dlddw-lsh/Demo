package com.lsh.rabbitmq.two;

import com.lsh.rabbitmq.utils.RabbitUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 工作线程 相当于之前的消费者
 */
public class Worker01 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitUtils.getChannel();

    }
}
