package com.handl.springboot.common.mq.amqp;

import com.handl.springboot.pojo.entiry.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 * Created by handl on 2017/9/3.
 */
@Component
public class AmqpReceiver {

    @RabbitListener(queues = "springboot_amqp")
    public void receiverMsg(final Message<User> message){
        System.out.println("amqp消息接收-----------开始");
        MessageHeaders headers =  message.getHeaders();
        System.out.println("headers===="+headers);

        User user = message.getPayload();
        System.out.println("user===="+user);
        System.out.println("id===="+user.getId());
        System.out.println("name===="+user.getName());
        System.out.println("age===="+user.getAge());
        System.out.println("des===="+user.getDes());
        System.out.println("amqp消息接收-----------结束");
    }
}
