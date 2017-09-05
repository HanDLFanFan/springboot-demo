package com.handl.springboot.common.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by handl on 2017/8/26.
 *
 * 广播式
 *
 * 1.@EnableWebSocketMessageBroker : 开启使用STOMP协议来传输基于代理(
 *       message broker)的消息，这时控制器支持使用@MessageMapping,就像
 *       使用@RequestMapping一样。
 *
 * 2.注册STOMP协议节点(endpoint),并映射制定URL
 *
 * 3.注册STOMP的endpoint，并制定使用SockJS协议
 *
 * 4.配置消息代理器(message broker)
 *
 * 5.广播式需要配置一个/topic消息代理
 *   点对点式添加一个/queue消息代理
 *
 */
@Configuration
@EnableWebSocketMessageBroker //1
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) { //2
        registry.addEndpoint("/endpointWebSocket").withSockJS(); //3
        registry.addEndpoint("/endpointChat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { //4
        registry.enableSimpleBroker("/topic","/queue"); //5
    }

}
