package com.lsh.rabbitmqspring.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lsh
 * @description: TTL队列 配置文件类代码
 */
@Configuration
public class TtlQueueConfig {

    // 普通交换机的名称
    private static final String X_EXCHANGE = "X";
    // 死信交换机的名称
    private static final String Y_DEAD_LETTER_EXCHANGE = "Y";
    // 普通队列的名称
    private static final String QUEUE_A = "QA";
    private static final String QUEUE_B = "QB";
    private static final String QUEUE_C = "QC";
    // 死信队列的名称
    private static final String DEAD_LETTER_QUEUE = "QD";

    // 声明X交换机
    @Bean("xExchange")
    public DirectExchange xExchange() {
        return new DirectExchange(X_EXCHANGE);
    }

    // 声明Y交换机
    @Bean("yExchange")
    public DirectExchange yExchange() {
        return new DirectExchange(Y_DEAD_LETTER_EXCHANGE);
    }

    // 声明普通队列 TTL为10s
    @Bean("queueA")
    public Queue queueA() {
        Map<String, Object> arguments = new HashMap<>(3);
        // 设置死信交换机
        arguments.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        // 设置死信RoutingKey
        arguments.put("x-dead-letter-routing-key", "YD");
        // 设置TTL 单位是ms
        arguments.put("x-message-ttl", 10000);
        return QueueBuilder.durable(QUEUE_A).withArguments(arguments).build();
    }

    // 声明普通队列 TTL为40s
    @Bean("queueB")
    public Queue queueB() {
        Map<String, Object> arguments = new HashMap<>(3);
        // 设置死信交换机
        arguments.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        // 设置死信RoutingKey
        arguments.put("x-dead-letter-routing-key", "YD");
        // 设置TTL 单位是ms
        arguments.put("x-message-ttl", 40000);
        return QueueBuilder.durable(QUEUE_B).withArguments(arguments).build();
    }

    // 声明QC
    @Bean("queueC")
    public Queue queueC() {
        Map<String, Object> arguments = new HashMap<>(3);
        // 设置死信交换机
        arguments.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        // 设置死信RoutingKey
        arguments.put("x-dead-letter-routing-key", "YD");
        return QueueBuilder.durable(QUEUE_C).withArguments(arguments).build();
    }

    // 声明死信队列
    @Bean("queueD")
    public Queue queueD() {
        return QueueBuilder.durable(DEAD_LETTER_QUEUE).build();
    }

    // 设置绑定关系
    @Bean
    public Binding queueABindingX() {
        return BindingBuilder.bind(queueA()).to(xExchange()).with("XA");
    }

    // 设置绑定关系
    @Bean
    public Binding queueBBindingX() {
        return BindingBuilder.bind(queueB()).to(xExchange()).with("XB");
    }

    // 设置绑定关系
    @Bean
    public Binding queueCBindingX() {
        return BindingBuilder.bind(queueC()).to(xExchange()).with("XC");
    }

    // 设置绑定关系
    @Bean
    public Binding queueDBindingY() {
        return BindingBuilder.bind(queueD()).to(yExchange()).with("YD");
    }
}
