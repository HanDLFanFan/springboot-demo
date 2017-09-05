package com.handl.springboot.controller;

import com.handl.springboot.pojo.websocket.BrowserMessage;
import com.handl.springboot.pojo.websocket.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by handl on 2017/8/26.
 *
 * 1.@MessageMapping("/websocket"):当浏览器向服务器端发送请求时，通过@MessageMapping
 *          映射"/websocket"这个地址，类似@RequestMapping
 *
 * 2.@SendTo：当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
 *
 *
 */
@Controller
public class WebSocketController {

    /**
     * 广播
     * @param message
     * @return
     */
    @MessageMapping("/websocket") //1
    @SendTo("/topic/getResponse") //2
    public ServerMessage message(BrowserMessage message){
        System.out.println("已收到浏览器的请求，现在开始回复.....");
        System.out.println("name="+message.getName()+",age="+message.getAge()+",message="+message.getMessage());
        return new ServerMessage("server",18,"woshifuwuduan");
    }

    //通过SimpMessagingTemplate向浏览器发送消息
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    /**
     * 点对点式，添加了web安全
     * @param principal
     * @param msg
     */
    @MessageMapping("/chat")
    //springmvc中可以直接在参数中会的Principal，包含了用户信息
    public void handleChat(Principal principal,String msg){
        if(principal.getName().equals("usera")){
            System.out.println("hello 我是A,msg="+msg);
            //参数1：接受消息的用户   参数2：浏览器订阅的地址  参数3：消息本身
            messagingTemplate.convertAndSendToUser("userb",
                    "/queue/notifications",principal.getName()+
                    "-send:"+msg);
        }else{
            System.out.println("hello 我是B,msg="+msg);
            messagingTemplate.convertAndSendToUser("usera",
                    "/queue/notifications",principal.getName()+
                            "-send:"+msg);
        }
    }

}
