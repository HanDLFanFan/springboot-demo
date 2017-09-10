package com.handl.springboot.common.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by handl on 2017/9/10.
 */
@Configuration
@MapperScan(basePackages = {"com.handl.springboot.mapper"})
public class MyBatisConfig {
}
