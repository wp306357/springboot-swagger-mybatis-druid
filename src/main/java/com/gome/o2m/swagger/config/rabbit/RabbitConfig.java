package com.gome.o2m.swagger.config.rabbit;

import com.gome.o2m.swagger.common.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/9/25.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queueMessage(){
        return new Queue(Constants.TOPIC_MESSAGE);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(Constants.TOPIC_MESSAGES);
    }

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(Constants.TOPIC_EXCHANGE_NAME);
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessage, TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.#");
    }
}
