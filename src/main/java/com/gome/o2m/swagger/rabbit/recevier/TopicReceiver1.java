package com.gome.o2m.swagger.rabbit.recevier;

import com.gome.o2m.swagger.common.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收队列queue1(topic.message)的消息
 * Created by Administrator on 2017/9/25.
 */
@Component
@RabbitListener(queues = Constants.TOPIC_MESSAGE)
public class TopicReceiver1 {

    @RabbitHandler
    public void handler(String message){
        System.out.println("Topic Receiver1  : " + message);
    }
}
