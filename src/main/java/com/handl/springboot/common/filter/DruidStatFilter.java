package com.handl.springboot.common.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by handl on 2017/9/16.
 */
// druid过滤器.
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
    initParams = {
        // 忽略资源
        @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
    }
)
public class DruidStatFilter extends WebStatFilter {
}
