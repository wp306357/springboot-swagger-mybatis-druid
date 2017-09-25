package com.gome.o2m.swagger.rabbit.sender;

import com.gome.o2m.swagger.common.Constants;
import com.gome.o2m.swagger.config.rabbit.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/9/25.
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 交换机会转发到queue2(topic.messages)队列中
     */
    public void send(){
        String context = "hi, i am message all";
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend(Constants.TOPIC_EXCHANGE_NAME, "topic.1", context);
    }

    /**
     * 交换机会转发到queue1(topic.message)和queue2(topic.messages)队列中
     */
    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(Constants.TOPIC_EXCHANGE_NAME, "topic.message", context);
    }

    /**
     * 交换机会转发到queue2(topic.messages)队列中
     */
    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(Constants.TOPIC_EXCHANGE_NAME, "topic.messages", context);
    }
}
