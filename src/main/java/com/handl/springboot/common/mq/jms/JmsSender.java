package com.handl.springboot.common.mq.jms;

import com.handl.springboot.pojo.entiry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by handl on 2017/9/3.
 *
 * 消息发送类：
 *  MessageCreator
 *
 */
@Component
public class JmsSender {

    @Autowired
    private JmsOperations jmsOperations;

    public void sendMsg(User user){
        System.out.println("jms消息发送------开始");
        jmsOperations.send("springboot_jms",new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(user);
            }
        });
        System.out.println("jms消息发送------完成");
    }

}
