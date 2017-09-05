package com.handl.springboot.common.spring;

import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by handl on 2017/9/3.
 */
@Configuration
public class AmqpConfig {

    @Bean
    public Queue creatQueue(){
        return new Queue("springboot_amqp");
    }
}
