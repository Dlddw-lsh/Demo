package com.lsh.rabbitmqspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lsh
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/ttl")
public class SendMsgController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg/{msg}")
    public void sendMsg(@PathVariable String msg) {
        log.info("当前时间:{},发送一条信息给两个ttl队列:{}", new Date(), msg);

        rabbitTemplate.convertAndSend("X", "XA", "消息来自ttl为10s的队列：" + msg);
        rabbitTemplate.convertAndSend("X", "XB", "消息来自ttl为40s的队列：" + msg);
    }
}
