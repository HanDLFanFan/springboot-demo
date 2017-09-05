package com.handl.springboot.common.mq.amqp;

import com.handl.springboot.pojo.entiry.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by handl on 2017/9/3.
 */
@Component
public class AmqpSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(User user){
        System.out.println("amqp消息发送------开始");
        rabbitTemplate.convertAndSend("springboot_amqp",user);
        System.out.println("amqp消息发送------完成");
    }

}
