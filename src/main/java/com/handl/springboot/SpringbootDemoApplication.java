package com.handl.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}
