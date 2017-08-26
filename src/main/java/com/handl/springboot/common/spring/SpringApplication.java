package com.handl.springboot.common.spring;

import com.handl.springboot.common.filter.MyFilter;
import com.handl.springboot.common.listener.MyListener;
import com.handl.springboot.common.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by handl on 2017/8/25.
 *
 * 注册Servlet、Filter、Listener
 *
 */
@Configuration
public class SpringApplication {

    /*@Bean
    public ServletListenerRegistrationBean servletListenerRegistration(){
        return new ServletListenerRegistrationBean(new MyListener());
    }

    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean servletRegistration(){
        return new ServletRegistrationBean(new MyServlet(),"/");
    }
*/
}
