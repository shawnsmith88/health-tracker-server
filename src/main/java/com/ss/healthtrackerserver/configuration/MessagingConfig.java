package com.ss.healthtrackerserver.configuration;

import com.ss.healthtrackerserver.enums.Exchanges;
import com.ss.healthtrackerserver.enums.RoutingKeys;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class MessagingConfig {
    static final String topicExchangeName = Exchanges.WORKOUTS;
    static final String queueName = "health-tracker";

    @Bean
    Queue queue(){
        Queue queue=new Queue(queueName,true);

        return queue;
    }
    @Bean
    TopicExchange topicExchange(){
        TopicExchange topicExchange=new TopicExchange(topicExchangeName);
        return topicExchange;
    }
    @Bean
    CachingConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory connectionFactory= new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }
    @Bean
    ConnectionFactory connectionFactory() {
        return cachingConnectionFactory();
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(RoutingKeys.NEWWORKOUT);
    }
}
