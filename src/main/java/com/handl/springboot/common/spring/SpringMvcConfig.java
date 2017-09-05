package com.handl.springboot.common.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by handl on 2017/8/25.
 *
 * 修改springboot的mvc默认配置
 * 继承WebMvcConfigurerAdapter后的 修改是覆盖和局部修改
 *
 */
//继承WebMvcConfigurerAdapter不用写@EnableWebMvc
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 不会覆盖SpringBoot默认的自动配置
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*registry.addViewController("/index").setViewName("index");
        registry.addViewController("/ws").setViewName("websocket");
        registry.addViewController("/login").setViewName("loginwebsocket");
        registry.addViewController("/chat").setViewName("websocketchat");*/
    }
}
