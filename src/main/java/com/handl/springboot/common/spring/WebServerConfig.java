package com.handl.springboot.common.spring;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by handl on 2017/8/25.
 * 修改内置web服务器的配置：如端口号，ssl协议，http转换https等等
 */
@Configuration
public class WebServerConfig {

    /**
     * tomcat配置
     * @return
     */
    @Bean
    public EmbeddedServletContainerFactory tomcat(){
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        factory.addAdditionalTomcatConnectors(httpConnector());
        return factory;
    }

    /**
     * 设置tomcat（此方法可以通用）的http自动转向https  80转向8443
     * @return
     */
    @Bean
    public Connector httpConnector(){
        Connector connector = new Connector(
                "org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(80);
        connector.setSecure(false);
        connector.setRedirectPort(8443);
        return connector;
    }

}
