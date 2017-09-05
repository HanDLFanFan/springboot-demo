package com.handl.springboot;

import com.handl.springboot.common.mq.amqp.AmqpSender;
import com.handl.springboot.common.mq.jms.JmsSender;
import com.handl.springboot.dao.UserRepository;
import com.handl.springboot.pojo.entiry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * 1.@SpringBootApplication:是SpringBoot项目的核心注解，主要目的是开启自动配置
 * 		艾特SpringBootApplication注解是一个组合注解，主要组合了
 * 					艾特Configuration
 * 					艾特EnableAutoConfiguration
 * 					艾特CompomentScan
 * 		艾特EnableAutoConfiguration:让Spring Boot根据类路径中的jar包依赖为当前项目
 * 					进行配置，例如spring-boot-starter-data-web依赖，会添加tomcat和
 * 					sring mvc的依赖，那么springBoot会对tomcat和spring mvc进行配置
 * 		SpringBoot会自动扫描@SpringBootApplication所在类的同级包，以及下级包内的bean，
 * 					所以建议入口类放在在根目录下
 *
 *
 * 2.main方法：作为项目启动入口，运行main方法启动项目。
 *
 * 3.关闭特定的自动配置：可通过@SpringBootApplication注解的exclude参数修改
 * 			例如：关闭数据源的自动配置
 * 			@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 *
 *
 * 3.定制banner:spring boot项目启动时有一个logo，按如下操作修改logo：
 * 			1):在src/main/resource下新建一个banner.txt
 * 			2):通过http://patorjk.com/software/taag网站生成字符，将网站字符复制到banner.txt中
 *
 * 4.实现CommandLineRunner接口并重写run方法，项目启动时自动执行
 *
 *
 */
@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching	//启动缓存
public class SpringbootDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Autowired
	private JmsSender jmsSender;
	@Autowired
	private AmqpSender amqpSender;

	@Autowired
	private UserRepository userRepository;

	/**
	 *
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		User user =userRepository.findOne((long) 1);
		//jms(user);
		amqp(user);
	}

	public void amqp(User user){
		amqpSender.sendMsg(user);
	}

	public void jms(User user){
		jmsSender.sendMsg(user);
	}
}
